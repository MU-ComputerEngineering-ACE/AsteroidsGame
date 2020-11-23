import greenfoot.GreenfootSound;
import greenfoot.Greenfoot;
 
public abstract class BgMusic extends Object
{
    public static final String[] soundFiles =
    {
        "Matrix & Futurebound - Control (ft. Max Marshall).mp3",
        "Sword Art Online 2 OST Extended Inside Information.mp3",
        "Pendulum, Zedd ft. Foxes, B.o.B, Rob Swire - Claritycraft [ZOMBIEE GRAPHICS] (320  kbps).mp3",
        "Tokyo Ghoul OST 1 - Track 03 - Ken Kaneki.mp3",
        "Boku no Hero Academia OST 01 - You Say RunTheme Song - Plus Ultra.mp3",
        "Naruto - 03 - Fake.mp3",
        "Sword Art Online 2 OST Extended The Psychedelic World.mp3",
        "Fitz and the Tantrums - HandClap [Official Video] (320  kbps).mp3"
        
                
    };
    public static GreenfootSound bgm;
    public static void newsong()
    {
        bgm = new GreenfootSound(soundFiles[Greenfoot.getRandomNumber(soundFiles.length)]); 
    }
    public static void play()
    {
        if (bgm == null || !bgm.isPlaying())
        {
            bgm.play();
            bgm.setVolume(25);
        }
    }
    public static void stop()
    {
        bgm.stop();
    }
    public static void setVolume()
    {
        bgm.setVolume(75);
    }
}