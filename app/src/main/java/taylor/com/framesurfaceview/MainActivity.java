package taylor.com.framesurfaceview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import taylor.lib.framesurfaceview.FrameSurfaceView;

public class MainActivity extends AppCompatActivity  {

    private FrameSurfaceView frameSurfaceView;
    private List<String> starts;
    private List<String> listenings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            starts.add("huanxing_0000" + i + ".webp");
        }

        listenings = new ArrayList<>();
        for (int i = 10; i < 90; i++) {
            listenings.add("huanxing_000" + i + ".webp");
        }


        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play frame animation by FrameSurfaceView which is much more memory-efficient than AnimationDrawable
                frameSurfaceView.start();
                frameSurfaceView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frameSurfaceView.setBitmapIds(listenings);
                        frameSurfaceView.setRepeatTimes(-1);
                        frameSurfaceView.start();
                        frameSurfaceView.setDuration(3200);
                    }
                },400);
            }
        });

        frameSurfaceView = findViewById(R.id.sv_frame);
        frameSurfaceView.setBitmapIds(starts);
        frameSurfaceView.setDuration(400);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        frameSurfaceView.destroy();
    }
}
