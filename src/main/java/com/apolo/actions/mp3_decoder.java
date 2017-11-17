/*https://github.com/Delthas/JavaMP3 */
package com.apolo.actions;

import fr.delthas.javamp3.Sound;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mp3_decoder {

    final private String path_ofsong = "\\songlist";

    public mp3_decoder() {
    }

    public void mp3_decoder_to_Frequency(String name) {
        Path path = Paths.get(path_ofsong, name + ".mp3");

        System.out.println(path + "inginging");
        int n;
        try (InputStream in = Files.newInputStream(path)) {
            while ((n = in.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        //try(BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))){ System.out.println(bis.toString()+"..bisbis");}catch(IOException e){System.out.println(e+"~BufferedInputStream");}
        /*try (Sound sound = new Sound(new BufferedInputStream(Files.newInputStream(path)))) {
            System.out.println(sound + "..soundsound");
        } catch (IOException e) {
            System.out.println(e + "~sound");
        }

        try (Sound sound = new Sound(new BufferedInputStream(Files.newInputStream(path)))) {
            // no need to buffer the SoundInputStream

            // get sound metadata
            //System.out.println(sound.getSamplingFrequency());
            System.out.println("yayaya");
            // let's copy the decoded data samples into a file!
            Files.copy(sound, Paths.get("/songlist/" + name + ".raw"
            ));
        } catch (IOException e) {
            System.out.println(e + "~mp3_decoder_to_Frequency");
        }*/
    }
}
