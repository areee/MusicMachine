// Kesken! Yritän tähän parannella sovelluslogiikan musiikkitoimintoja
// erään JavaSound-esimerkin avulla.

//package musicmachine.logic;
//
//import java.awt.*;
//import java.awt.font.*;
//import java.awt.geom.*;
//import java.awt.event.*;
//import java.text.AttributedString;
//import java.text.AttributedCharacterIterator;
//import javax.swing.*;
//import javax.swing.border.*;
//import javax.swing.table.*;
//import javax.swing.event.*;
//import javax.sound.midi.*;
//import javax.sound.sampled.*;
//import java.io.File;
//import java.io.InputStream;
//import java.io.FileInputStream;
//import java.io.BufferedInputStream;
//import java.util.Vector;
//import java.net.URL;
//
///**
// * Luokka hoitaa MusicMachinen musiikkitiedostojen toistot, lisäämiset ja
// * poistot.
// */
//public class NewSovelluslogiikka extends JPanel implements Runnable, LineListener, MetaEventListener {
//
//    final int bufSize = 16384;
//    PlaybackMonitor playbackMonitor = new PlaybackMonitor();
//
//    Vector sounds = new Vector();
//    Thread thread;
//    Sequencer sequencer;
//    boolean midiEOM, audioEOM;
//    Synthesizer synthesizer;
//    MidiChannel channels[];
//    Object currentSound;
//    String currentName;
//    double duration;
//    int num;
//    boolean bump;
//    boolean paused = false;
//    JButton startB, pauseB, loopB, prevB, nextB;
//    JTable table;
//    JSlider panSlider, gainSlider;
//    JSlider seekSlider;
//    JukeTable jukeTable;
//    Loading loading;
//    Credits credits;
//    String errStr;
//    JukeControls controls;
//
//    public NewSovelluslogiikka(String dirName) {
//        setLayout(new BorderLayout());
//        setBorder(new EmptyBorder(5, 5, 5, 5));
//
//        if (dirName != null) {
//            loadJuke(dirName);
//        }
//
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
//                jukeTable = new JukeTable(), controls = new JukeControls());
//        splitPane.setContinuousLayout(true);
//        add(splitPane);
//    }
//
//    public void open() {
//
//        try {
//
//            sequencer = MidiSystem.getSequencer();
//
//            if (sequencer instanceof Synthesizer) {
//                synthesizer = (Synthesizer) sequencer;
//                channels = synthesizer.getChannels();
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return;
//        }
//        sequencer.addMetaEventListener(this);
//        (credits = new Credits()).start();
//    }
//
//    public void close() {
//        if (credits != null && credits.isAlive()) {
//            credits.interrupt();
//        }
//        if (thread != null && startB != null) {
//            startB.doClick(0);
//        }
//        if (jukeTable != null && jukeTable.frame != null) {
//            jukeTable.frame.dispose();
//            jukeTable.frame = null;
//        }
//        if (sequencer != null) {
//            sequencer.close();
//        }
//    }
//
//    public void loadJuke(String name) {
//        try {
//            File file = new File(name);
//            if (file != null && file.isDirectory()) {
//                String files[] = file.list();
//                for (int i = 0; i < files.length; i++) {
//                    File leafFile = new File(file.getAbsolutePath(), files[i]);
//                    if (leafFile.isDirectory()) {
//                        loadJuke(leafFile.getAbsolutePath());
//                    } else {
//                        addSound(leafFile);
//                    }
//                }
//            } else if (file != null && file.exists()) {
//                addSound(file);
//            }
//        } catch (SecurityException ex) {
//            reportStatus(ex.toString());
////            JavaSound.showInfoDialog();
//        } catch (Exception ex) {
//            reportStatus(ex.toString());
//        }
//    }
//
//    private void addSound(File file) {
//        String s = file.getName();
//        if (s.endsWith(".au") || s.endsWith(".rmf")
//                || s.endsWith(".mid") || s.endsWith(".wav")
//                || s.endsWith(".aif") || s.endsWith(".aiff")) {
//            sounds.add(file);
//        }
//    }
//
//    public boolean loadSound(Object object) {
//
//        duration = 0.0;
//        (loading = new Loading()).start();
//
//        if (object instanceof URL) {
//            currentName = ((URL) object).getFile();
//            playbackMonitor.repaint();
//            try {
//                currentSound = AudioSystem.getAudioInputStream((URL) object);
//            } catch (Exception e) {
//                try {
//                    currentSound = MidiSystem.getSequence((URL) object);
//                } catch (InvalidMidiDataException imde) {
//                    System.out.println("Unsupported audio file.");
//                    return false;
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    currentSound = null;
//                    return false;
//                }
//            }
//        } else if (object instanceof File) {
//            currentName = ((File) object).getName();
//            playbackMonitor.repaint();
//            try {
//                currentSound = AudioSystem.getAudioInputStream((File) object);
//            } catch (Exception e1) {
//                // load midi & rmf as inputstreams for now
//                //try { 
//                //currentSound = MidiSystem.getSequence((File) object);
//                //} catch (Exception e2) { 
//                try {
//                    FileInputStream is = new FileInputStream((File) object);
//                    currentSound = new BufferedInputStream(is, 1024);
//                } catch (Exception e3) {
//                    e3.printStackTrace();
//                    currentSound = null;
//                    return false;
//                }
//                //}
//            }
//        }
//
//        loading.interrupt();
//
//        // user pressed stop or changed tabs while loading
//        if (sequencer == null) {
//            currentSound = null;
//            return false;
//        }
//
//        if (currentSound instanceof AudioInputStream) {
//            try {
//                AudioInputStream stream = (AudioInputStream) currentSound;
//                AudioFormat format = stream.getFormat();
//
//                /**
//                 * we can't yet open the device for ALAW/ULAW playback, convert
//                 * ALAW/ULAW to PCM
//                 */
//                if ((format.getEncoding() == AudioFormat.Encoding.ULAW)
//                        || (format.getEncoding() == AudioFormat.Encoding.ALAW)) {
//                    AudioFormat tmp = new AudioFormat(
//                            AudioFormat.Encoding.PCM_SIGNED,
//                            format.getSampleRate(),
//                            format.getSampleSizeInBits() * 2,
//                            format.getChannels(),
//                            format.getFrameSize() * 2,
//                            format.getFrameRate(),
//                            true);
//                    stream = AudioSystem.getAudioInputStream(tmp, stream);
//                    format = tmp;
//                }
//                DataLine.Info info = new DataLine.Info(
//                        Clip.class,
//                        stream.getFormat(),
//                        ((int) stream.getFrameLength()
//                        * format.getFrameSize()));
//
//                Clip clip = (Clip) AudioSystem.getLine(info);
//                clip.addLineListener(this);
//                clip.open(stream);
//                currentSound = clip;
//                seekSlider.setMaximum((int) stream.getFrameLength());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                currentSound = null;
//                return false;
//            }
//        } else if (currentSound instanceof Sequence || currentSound instanceof BufferedInputStream) {
//            try {
//                sequencer.open();
//                if (currentSound instanceof Sequence) {
//                    sequencer.setSequence((Sequence) currentSound);
//                } else {
//                    sequencer.setSequence((BufferedInputStream) currentSound);
//                }
//                seekSlider.setMaximum((int) (sequencer.getMicrosecondLength() / 1000));
//
//            } catch (InvalidMidiDataException imde) {
//                System.out.println("Unsupported audio file.");
//                currentSound = null;
//                return false;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                currentSound = null;
//                return false;
//            }
//        }
//
//        seekSlider.setValue(0);
//
//        // enable seek, pan, and gain sliders for sequences as well as clips
//        seekSlider.setEnabled(true);
//        panSlider.setEnabled(true);
//        gainSlider.setEnabled(true);
//
//        duration = getDuration();
//
//        return true;
//    }
//
//    public void playSound() {
//        playbackMonitor.start();
//        setGain();
//        setPan();
//        midiEOM = audioEOM = bump = false;
//        if (currentSound instanceof Sequence || currentSound instanceof BufferedInputStream && thread != null) {
//            sequencer.start();
//            while (!midiEOM && thread != null && !bump) {
//                try {
//                    thread.sleep(99);
//                } catch (Exception e) {
//                    break;
//                }
//            }
//            sequencer.stop();
//            sequencer.close();
//        } else if (currentSound instanceof Clip && thread != null) {
//            Clip clip = (Clip) currentSound;
//            clip.start();
//            try {
//                thread.sleep(99);
//            } catch (Exception e) {
//            }
//            while ((paused || clip.isActive()) && thread != null && !bump) {
//                try {
//                    thread.sleep(99);
//                } catch (Exception e) {
//                    break;
//                }
//            }
//            clip.stop();
//            clip.close();
//        }
//        currentSound = null;
//        playbackMonitor.stop();
//    }
//
//    public double getDuration() {
//        double duration = 0.0;
//        if (currentSound instanceof Sequence) {
//            duration = ((Sequence) currentSound).getMicrosecondLength() / 1000000.0;
//        } else if (currentSound instanceof BufferedInputStream) {
//            duration = sequencer.getMicrosecondLength() / 1000000.0;
//        } else if (currentSound instanceof Clip) {
//            Clip clip = (Clip) currentSound;
//            duration = clip.getBufferSize()
//                    / (clip.getFormat().getFrameSize() * clip.getFormat().getFrameRate());
//        }
//        return duration;
//    }
//
//    public double getSeconds() {
//        double seconds = 0.0;
//        if (currentSound instanceof Clip) {
//            Clip clip = (Clip) currentSound;
//            seconds = clip.getFramePosition() / clip.getFormat().getFrameRate();
//        } else if ((currentSound instanceof Sequence) || (currentSound instanceof BufferedInputStream)) {
//            try {
//                seconds = sequencer.getMicrosecondPosition() / 1000000.0;
//            } catch (IllegalStateException e) {
//                System.out.println("TEMP: IllegalStateException "
//                        + "on sequencer.getMicrosecondPosition(): " + e);
//            }
//        }
//        return seconds;
//    }
//
//    @Override
//    public void update(LineEvent event) {
//        if (event.getType() == LineEvent.Type.STOP && !paused) {
//            audioEOM = true;
//        }
//    }
//
//    @Override
//    public void meta(MetaMessage meta) {
//        if (meta.getType() == 47) {  // 47 is end of track
//            midiEOM = true;
//        }
//    }
//
//    private void reportStatus(String msg) {
//        if ((errStr = msg) != null) {
//            System.out.println(errStr);
//            playbackMonitor.repaint();
//        }
//        if (credits != null && credits.isAlive()) {
//            credits.interrupt();
//        }
//    }
//
//    public Thread getThread() {
//        return thread;
//    }
//
//    public void start() {
//        thread = new Thread(this);
//        thread.setName("Juke");
//        thread.start();
//    }
//
//    public void stop() {
//        if (thread != null) {
//            thread.interrupt();
//        }
//        thread = null;
//    }
//
//    @Override
//    public void run() {
//        do {
//            table.scrollRectToVisible(new Rectangle(0, 0, 1, 1));
//            for (; num < sounds.size() && thread != null; num++) {
//                table.scrollRectToVisible(new Rectangle(0, (num + 2) * (table.getRowHeight() + table.getRowMargin()), 1, 1));
//                table.setRowSelectionInterval(num, num);
//                if (loadSound(sounds.get(num)) == true) {
//                    playSound();
//                }
//                // take a little break between sounds
//                try {
//                    thread.sleep(222);
//                } catch (Exception e) {
//                    break;
//                }
//            }
//            num = 0;
//        } while (loopB.isSelected() && thread != null);
//
//        if (thread != null) {
//            startB.doClick();
//        }
//        thread = null;
//        currentName = null;
//        currentSound = null;
//        playbackMonitor.repaint();
//    }
//
//    public void setPan() {
//
//        int value = panSlider.getValue();
//
//        if (currentSound instanceof Clip) {
//            try {
//                Clip clip = (Clip) currentSound;
//                FloatControl panControl
//                        = (FloatControl) clip.getControl(FloatControl.Type.PAN);
//                panControl.setValue(value / 100.0f);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else if (currentSound instanceof Sequence || currentSound instanceof BufferedInputStream) {
//            for (int i = 0; i < channels.length; i++) {
//                channels[i].controlChange(10, (int) (((double) value + 100.0) / 200.0 * 127.0));
//            }
//        }
//    }
//
//    public void setGain() {
//        double value = gainSlider.getValue() / 100.0;
//
//        if (currentSound instanceof Clip) {
//            try {
//                Clip clip = (Clip) currentSound;
//                FloatControl gainControl
//                        = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//                float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
//                gainControl.setValue(dB);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else if (currentSound instanceof Sequence || currentSound instanceof BufferedInputStream) {
//            for (int i = 0; i < channels.length; i++) {
//                channels[i].controlChange(7, (int) (value * 127.0));
//
//            }
//        }
//    }
//
//}
