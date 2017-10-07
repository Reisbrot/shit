package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh.Type;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.SpotLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.CollisionData;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import java.util.Random;


public class Main extends SimpleApplication {
    Vector3f shitPos1, shitPos2;
    int count;
    Boolean isRunning = true;
    ParticleEmitter animation;
    Material mat, bg, bg2, bg3, bg4;
    Geometry pipe, pipe2;
    Texture pipe001_001, pipe001_001s, pipe001_010, pipe001_010s, pipe001_011s, pipe001_100, pipe001_100l, pipe001_100s, pipe001_101, pipe001_101s, pipe001_110, pipe001_110a, pipe001_111s, pipe010_001, pipe010_010, pipe010_010l, pipe010_010s, pipe010_011, pipe010_100, pipe010_101, pipe010_110, pipe010_111, pipe011_001, pipe011_010s, pipe011_011, pipe011_011s, pipe011_100, pipe011_101, pipe011_110, pipe011_110s, pipe011_111, pipe011_111a, pipe011_111s, pipe100_001, pipe100_001l, pipe100_001s, pipe100_010, pipe100_010s, pipe100_011, pipe100_011a, pipe100_100, pipe100_100s, pipe100_101, pipe100_101s, pipe100_110s, pipe100_111s, pipe101_010l, pipe101_011, pipe101_011s, pipe101_101, pipe101_101s, pipe101_110, pipe101_110s, pipe110_001, pipe110_010s, pipe110_011, pipe110_011s, pipe110_100, pipe110_101, pipe110_110, pipe110_110s, pipe110_111, pipe110_111a, pipe110_111aa, pipe110_111aas, pipe110_111s, pipe111_001, pipe111_010l, pipe111_011s, pipe111_011l, pipe111_100, pipe111_101left, pipe111_101right, pipe111_110l, pipe111_110s, pipe111_111, pipe111_111extralong, pipe111_111s;

    public static void main(String[] args) {

        
        AppSettings settings = new AppSettings(true);
        settings.setTitle("104.27.140.189");
        settings.setUseJoysticks(true);
        settings.setFullscreen(true);
        settings.setResolution(1440, 900);
        Main app = new Main();
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        restart();
        
        flyCam.setEnabled(false);
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrown_spritesheetV2.png"));
        animation = new ParticleEmitter("Forward", Type.Triangle, 1);  
        animation.setMaterial(mat);
        animation.setHighLife(3);
        animation.setLowLife(3);
        animation.setImagesX(16);
        animation.setImagesY(1);
        animation.setStartSize(0.65f);
        animation.setEndSize(0.65f);
        
        mat.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
        animation.setQueueBucket(Bucket.Transparent);
        animation.setGravity(0,0,0);
        animation.setInWorldSpace(false);
        
        
        Box pipe_short = new Box(5,5,0);
        Box pipe_medi = new Box(5,5,0);
        Box pipe_long = new Box(5,5,0);
        pipe = new Geometry("Box", pipe_medi);
        pipe2 = new Geometry("Box", pipe_medi);
        bg = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        bg2 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        bg3 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        bg4 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        pipe001_001 = assetManager.loadTexture("Pipes/001-001.png");
        pipe001_001s = assetManager.loadTexture("Pipes/001-001_short.png");
        pipe001_010 = assetManager.loadTexture("Pipes/001-010.png");
        pipe001_010s = assetManager.loadTexture("Pipes/001-010_short.png");
        pipe001_011s = assetManager.loadTexture("Pipes/001-011_short.png");
        pipe001_100 = assetManager.loadTexture("Pipes/001-100.png");
        pipe001_100l = assetManager.loadTexture("Pipes/001-100_long.png");
        pipe001_100s = assetManager.loadTexture("Pipes/001-100_short.png");
        pipe001_101 = assetManager.loadTexture("Pipes/001-101.png");
        pipe001_101s = assetManager.loadTexture("Pipes/001-101_short.png");
        pipe001_110 = assetManager.loadTexture("Pipes/001-110.png");
        pipe001_110a = assetManager.loadTexture("Pipes/001-110_alter.png");
        pipe001_111s = assetManager.loadTexture("Pipes/001-111_short.png");
        pipe010_001 = assetManager.loadTexture("Pipes/010-001.png");
        pipe010_010 = assetManager.loadTexture("Pipes/010-010.png");
        pipe010_010l = assetManager.loadTexture("Pipes/010-010_long.png");
        pipe010_010s = assetManager.loadTexture("Pipes/010-010_short.png");
        pipe010_011 = assetManager.loadTexture("Pipes/010-011.png");
        pipe010_100 = assetManager.loadTexture("Pipes/010-100.png");
        pipe010_101 = assetManager.loadTexture("Pipes/010-101.png");
        pipe010_110 = assetManager.loadTexture("Pipes/010-110.png");
        pipe010_111 = assetManager.loadTexture("Pipes/010-111.png");
        pipe011_001 = assetManager.loadTexture("Pipes/011-001.png");
        pipe011_010s = assetManager.loadTexture("Pipes/011-010_short.png");
        pipe011_011 = assetManager.loadTexture("Pipes/011-011.png");
        pipe011_011s = assetManager.loadTexture("Pipes/011-011_short.png");
        pipe011_100 = assetManager.loadTexture("Pipes/011-100.png");
        pipe011_101 = assetManager.loadTexture("Pipes/011-101.png");
        pipe011_110 = assetManager.loadTexture("Pipes/011-110_alter.png");
        pipe011_110s = assetManager.loadTexture("Pipes/011-110_short.png");
        pipe011_111 = assetManager.loadTexture("Pipes/011-111.png");
        pipe011_111a = assetManager.loadTexture("Pipes/011-111_alter.png");
        pipe011_111s = assetManager.loadTexture("Pipes/011-111_alter2_short.png");
        pipe100_001 = assetManager.loadTexture("Pipes/100-001.png");
        pipe100_001l = assetManager.loadTexture("Pipes/100-001_long.png");
        pipe100_001s = assetManager.loadTexture("Pipes/100-001_short.png");
        pipe100_010 = assetManager.loadTexture("Pipes/100-010_alter.png");
        pipe100_010s = assetManager.loadTexture("Pipes/100-010_short.png");
        pipe100_011 = assetManager.loadTexture("Pipes/100-011.png");
        pipe100_011a = assetManager.loadTexture("Pipes/100-011_alter.png");
        pipe100_100 = assetManager.loadTexture("Pipes/100-100.png");
        pipe100_100s = assetManager.loadTexture("Pipes/100-100_short.png");
        pipe100_101 = assetManager.loadTexture("Pipes/100-101_alter.png");
        pipe100_101s = assetManager.loadTexture("Pipes/100-101_short.png");
        pipe100_110s = assetManager.loadTexture("Pipes/100-110_short.png");
        pipe100_111s = assetManager.loadTexture("Pipes/100-111_short.png");
        pipe101_010l = assetManager.loadTexture("Pipes/101-010_long.png");
        pipe101_011 = assetManager.loadTexture("Pipes/101-011_alter.png");
        pipe101_011s = assetManager.loadTexture("Pipes/101-011_short.png");
        pipe101_101 = assetManager.loadTexture("Pipes/101-101.png");
        pipe101_101s = assetManager.loadTexture("Pipes/101-101_short.png");
        pipe101_110 = assetManager.loadTexture("Pipes/101-110_alter.png");
        pipe101_110s = assetManager.loadTexture("Pipes/101-110_short.png");
        pipe110_001 = assetManager.loadTexture("Pipes/110-001.png");
        pipe110_010s = assetManager.loadTexture("Pipes/110-010_short.png");
        pipe110_011 = assetManager.loadTexture("Pipes/110-011_alter.png");
        pipe110_011s = assetManager.loadTexture("Pipes/110-011_short.png");
        pipe110_100 = assetManager.loadTexture("Pipes/110-100.png");
        pipe110_101 = assetManager.loadTexture("Pipes/110-101.png");
        pipe110_110 = assetManager.loadTexture("Pipes/110-110.png");
        pipe110_110s = assetManager.loadTexture("Pipes/110-110_short.png");
        pipe110_111 = assetManager.loadTexture("Pipes/110-111.png");
        pipe110_111a = assetManager.loadTexture("Pipes/110-111_alter.png");
        pipe110_111aa = assetManager.loadTexture("Pipes/110-111_alter2.png");
        pipe110_111aas = assetManager.loadTexture("Pipes/110-111_alter2_short.png");
        pipe111_001 = assetManager.loadTexture("Pipes/111-001.png");
        pipe111_010l = assetManager.loadTexture("Pipes/111-010_long.png");
        pipe111_011l = assetManager.loadTexture("Pipes/111-011_long.png");
        pipe111_011s = assetManager.loadTexture("Pipes/111-011_short.png");
        pipe111_100 = assetManager.loadTexture("Pipes/111-100.png");
        pipe111_101left = assetManager.loadTexture("Pipes/111-101_ left.png");
        pipe111_101right = assetManager.loadTexture("Pipes/111-101_right.png");
        pipe111_110l = assetManager.loadTexture("Pipes/111-110_long.png");
        pipe111_110s = assetManager.loadTexture("Pipes/111-110_short.png");
        pipe111_111 = assetManager.loadTexture("Pipes/111-111.png");
        pipe111_111extralong = assetManager.loadTexture("Pipes/111-111_extralong.png");
        pipe111_111s = assetManager.loadTexture("Pipes/111-111_short.png");
        
        
        
          
        bg.setTexture("ColorMap", pipe010_010);
        bg2.setTexture("ColorMap", pipe001_001);
        bg3.setTexture("ColorMap", pipe010_001);
        bg4.setTexture("ColorMap", pipe001_010);
        pipe.setMaterial(bg);
        pipe2.setMaterial(bg2);
        pipe.setLocalTranslation(0, 0, 0);
        pipe2.setLocalTranslation(0, -10, 0);

        rootNode.attachChild(pipe);
        rootNode.attachChild(pipe2);
        rootNode.attachChild(animation);
        initKeys();
    }

    @Override
    public void simpleUpdate(float tpf) {
        System.out.println(pipe.getLocalTranslation().y);
        
       if(pipe.getLocalTranslation().y < 9.4)
           pipe.move(0f, 0.0003f, 0f);
       else{
        if(pipe.getLocalTranslation().y > 9.4)
         pipe.setLocalTranslation(0, -10, 0);
       }
       
       if(pipe2.getLocalTranslation().y < 9.4)
           pipe2.move(0, 0.0003f, 0f);
       else{
        if(pipe2.getLocalTranslation().y > 9.4)
         pipe2.setLocalTranslation(0, -10, 0);
       }
       
       count++;
         if(count == 1)
           shitPos1 = animation.getLocalTranslation();
         else
           if(count == 100){
             count = 0;
             shitPos2 = animation.getLocalTranslation();
             if(shitPos1.x == shitPos2.x && shitPos1.z == shitPos2.z)
               setDefaultAnimation();
        }
      
      
    }
    
    private void initKeys() {
      
    // You can map one or several inputs to one named action
    inputManager.addMapping("Pause",  new KeyTrigger(KeyInput.KEY_P));
    inputManager.addMapping("Up",  new KeyTrigger(KeyInput.KEY_W));
    inputManager.addMapping("Down",  new KeyTrigger(KeyInput.KEY_S));
    inputManager.addMapping("Left",   new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_D));
    // Add the names to the action listener.
    inputManager.addListener(actionListener,"Pause");
    inputManager.addListener(analogListener,"Left", "Right", "Rotate", "Up", "Down");

    }
        
    private ActionListener actionListener = new ActionListener() {
      public void onAction(String name, boolean keyPressed, float tpf) {
        if(true){
          mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrown_spritesheet.png"));
          animation.setMaterial(mat);
          animation.setImagesX(11);
        }
        if (name.equals("Pause") && !keyPressed) {
          isRunning = !isRunning;
        }
    }
    };

    private AnalogListener analogListener = new AnalogListener() {
      public void onAnalog(String name, float value, float tpf) {
        if (isRunning) {
           if (name.equals("Right")) {
            Vector3f v = animation.getLocalTranslation();
            animation.setLocalTranslation(v.x + value*speed*3, v.y, v.z);
            mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrownright_spritesheet.png"));
            animation.setMaterial(mat);
            animation.setImagesX(8);
          }
           if (name.equals("Left")) {
            Vector3f v = animation.getLocalTranslation();
            animation.setLocalTranslation(v.x - value*speed*3, v.y, v.z);
            mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrownleft_spritesheet.png"));
            animation.setMaterial(mat);
            animation.setImagesX(8);
          }
           if (name.equals("Up"))   {
            Vector3f v = animation.getLocalTranslation();
            animation.setLocalTranslation(v.x, v.y + value*speed*3, v.z); 
            setDefaultAnimation();
         }
          if (name.equals("Down")) {
            Vector3f v = animation.getLocalTranslation();
            animation.setLocalTranslation(v.x, v.y - value*speed*3, v.z);
            setDefaultAnimation();
         }
       }  else {
          System.out.println("Press P to unpause.");
        }
      }
    };
    
    public void setDefaultAnimation(){
      mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrown_spritesheet.png"));
      animation.setMaterial(mat);
      animation.setImagesX(11);
    }
}
