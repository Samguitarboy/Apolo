/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apolo.actions;

import com.tagtraum.jipes.AbstractSignalProcessor;
import com.tagtraum.jipes.SignalProcessor;
import com.tagtraum.jipes.SignalPump;
import com.tagtraum.jipes.SignalSource;
import com.tagtraum.jipes.audio.AudioBuffer;
import com.tagtraum.jipes.audio.AudioSignalSource;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Jipes {

    public void transform(String songpath) throws UnsupportedAudioFileException, IOException, IllegalArgumentException {
        System.out.println("transform~~~~~~~");
        System.out.println(songpath);
        SignalSource<AudioBuffer> source = new AudioSignalSource(new File(songpath));
        System.out.println("transform1~~~~~~~");
        SignalPump<AudioBuffer> pump = new SignalPump<AudioBuffer>(source);
        System.out.println("transform2~~~~~~~");
        zero_crossing_rate(pump);
        
    }

    public Float zero_crossing_rate(SignalPump<AudioBuffer> pump) throws IOException {
        String id = "ZCR";
        System.out.println("zero_crossing_rate~~~~~~");
        SignalProcessor<AudioBuffer, Float> zeroCrossingRateProcessor = new AbstractSignalProcessor<AudioBuffer, Float>(id) {
            private int samples;
            private int crossings;
            private float lastSample;

            /**
             * Computes the zero crossing rate for the given and all preceding
             * audio buffers.
             *
             * @param buffer audio buffer
             * @return current zero crossing rate
             */
            protected Float processNext(AudioBuffer buffer) throws IOException {
                // we assume a single-channel/mono source
                samples += buffer.getNumberOfSamples();
                for (final float sample : buffer.getData()) {
                    crossings += lastSample * sample >= 0 ? 0 : 1;
                    lastSample = sample;
                }
                return crossings / (float) samples;
            }
        };
        pump.add(zeroCrossingRateProcessor);
        Map<Object, Object> results = pump.pump();
        Float zeroCrossingRate = (Float) results.get(id);
        return zeroCrossingRate;
    }
}
