package com.example.tensorflowlitepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.checkerframework.checker.units.qual.C;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.task.core.BaseOptions;
import org.tensorflow.lite.task.vision.classifier.Classifications;
import org.tensorflow.lite.task.vision.classifier.ImageClassifier;
import org.tensorflow.lite.task.vision.detector.Detection;
import org.tensorflow.lite.task.vision.detector.ObjectDetector;
//import org.tensorflow.demo.env.BorderedText;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private static String modelFile = "template_model.tflite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        // Initialization
        ObjectDetector.ObjectDetectorOptions options =
                ObjectDetector.ObjectDetectorOptions.builder()
                        .setBaseOptions(BaseOptions.builder().build())
                        .setMaxResults(6)
                        .build();
        try {
            ObjectDetector objectDetector = ObjectDetector.createFromFileAndOptions(this, modelFile, options);
            List<Detection> results = objectDetector.detect(convertToTensorImage());
            filterResults(results);
        }
        catch(Exception e){
            Toast.makeText(this, ""+e.toString(), Toast.LENGTH_LONG).show();
            Log.e("ERROR", e.toString());
        }
    }

    public Bitmap convertToBitmap(){
        ImageView imgView = findViewById(R.id.imageView);
        imgView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable)imgView.getDrawable();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getBitmap());
        return bitmap;
    }

    public TensorImage convertToTensorImage(){
        TensorImage tensorImage = TensorImage.fromBitmap(convertToBitmap());
        return tensorImage;
    }


    public void showResults(View view) {
        Intent intent = new Intent(view.getContext(), HandleResults.class);
        startActivity(intent);
    }

    public void filterResults(List<Detection> results){
        int recycablesNumber = 0;
        int compostablesNumber = 0;

        for(int i=0;i<results.size();i++){
            Detection currentDetection = results.get(i);
            String category = currentDetection.getCategories().get(0).getLabel().toUpperCase();
            if(recycablesNumber>3 && compostablesNumber > 3){
                return;
            }
            if(TemporaryUtility.recycables.contains(category)){
                if(recycablesNumber<3){
                    TemporaryUtility.currentRecyclables.add(category);
                    recycablesNumber++;
                }
            }
            if(TemporaryUtility.compostables.contains(category)){
                if(compostablesNumber<3){
                    TemporaryUtility.currentCompostables.add(category);
                    compostablesNumber++;
                }
            }
            Log.w("CATEGORY", category);
        }
    }
}