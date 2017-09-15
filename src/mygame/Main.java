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

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    Vector3f shitPos1, shitPos2;
    int count;
    Boolean isRunning = true;
    ParticleEmitter animation;
    Material mat, bg, bg2, bg3, bg4;
    Geometry pipe, pipe2;
    Texture pipe_basic, pipe010_010, pipe010_010long, pipe010_010short, pipe001_001, pipe010_001, pipe001_010;

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
        pipe010_010 = assetManager.loadTexture("Pipes/010-010.png");
        pipe010_010long = assetManager.loadTexture("Pipes/010-010_long.png");
        pipe010_010short = assetManager.loadTexture("Pipes/010-010_short.png");
        pipe001_001 = assetManager.loadTexture("Pipes/001-001.png");
        pipe010_001 = assetManager.loadTexture("Pipes/010-001.png");
        pipe001_010 = assetManager.loadTexture("Pipes/001-010.png");
          
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
            mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrown_spritesheet.png"));
            animation.setMaterial(mat);
            animation.setImagesX(11);
         }
          if (name.equals("Down")) {
            Vector3f v = animation.getLocalTranslation();
            animation.setLocalTranslation(v.x, v.y - value*speed*3, v.z);
            mat.setTexture("ColorMap", assetManager.loadTexture("Spritesheets/mrbrown_spritesheet.png"));
            animation.setMaterial(mat);
            animation.setImagesX(11);
         }
        } else {
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
