/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 30, 2025
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amplified = new double[a.length];
        for (int i = 0; i < amplified.length; i++) {
            amplified[i] = a[i] * alpha;
        }
        return amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] reversed = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversed[reversed.length - 1 - i] = a[i];
        }
        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int length = a.length;
        if (b.length > length) length = b.length;
        double[] aCopy = new double[length];
        double[] bCopy = new double[length];
        for (int i = 0; i < length; i++) {
            if (i < a.length) aCopy[i] = a[i];
            else aCopy[i] = 0;

            if (i < b.length) bCopy[i] = b[i];
            else bCopy[i] = 0;
        }
        double[] mixed = new double[length];
        for (int i = 0; i < length; i++) {
            mixed[i] = aCopy[i] + bCopy[i];
        }
        return mixed;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] changed = new double[(int) Math.floor(a.length / alpha)];
        for (int i = 0; i < changed.length; i++) {
            changed[i] = a[(int) Math.floor(i * alpha)];
        }
        return changed;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] samplesCow = StdAudio.read("cow.wav");
        double[] samplesPiano = StdAudio.read("piano.wav");
        double[] samplesBeatbox = StdAudio.read("beatbox.wav");
        double[] samplesHarp = StdAudio.read("harp.wav");
        double[] samplesChimes = StdAudio.read("chimes.wav");
        StdAudio.play(amplify(samplesCow, 0.7));
        StdAudio.play(reverse(samplesHarp));
        StdAudio.play(merge(samplesChimes, samplesBeatbox));
        StdAudio.play(mix(samplesCow, samplesPiano));
        StdAudio.play(changeSpeed(samplesBeatbox, 2));
    }
}
