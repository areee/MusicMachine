# Testausdokumentti

En kyennyt testaamaan automaattisesti kaikkia äänitiedoston toistoon liittyviä sovelluslogiikan metodeja. Näin ollen laadin oheen joitakin toistoon liittyviä manuaalisia testejä.

Seuraavissa käyttötapauksissa ongelmia, eli bugeja esiintyi yliopiston Ubuntua käyttäessäni. Omalla Macillani näitä ongelmia ei testattessa esiintynyt.

## Toista tiedostoa normaalisti
1. Käynnistetään ohjelma.
2. Valitaan käyttöliittymäksi graafinen käyttöliittymä.
3. Lisätään musiikkitiedosto plus-painikkeesta.
4. Klikataan toista-painiketta.
5. Kuunnellaan äänitiedosto loppuun asti.
6. Ohjelman ylälaidassa näkyvä "Toistetaan..." -teksti ei vaihdu, vaikka ohjelman toisto on päättyt. Samoin toista-painikkeessa on edelleen pause-kuvake, vaikka ohjelman toisto on päättynyt.
7. Klikataan pysäytä-painiketta.
8. Konsoliin ilmestyy virheviesti ```Exception in thread "AWT-EventQueue-0" java.lang.IllegalStateException: Line not open```.
9. Toista-painike ei vaihdu takaisin play-kuvakkeeksi, vaikka näin pitäisi tapahtua.



## Valitse tiedoston toistokohta toistokohdan säätimellä
1. Toistetaan [Toista tiedostoa normaalisti](#toista-tiedostoa-normaalisti)-kohdan vaiheet 1-4.
2. Klikkaillaan toistokohdan säädintä toistokohdan oikealta puolelta.
3. Soivassa äänitiedostossa on kuultavissa pientä katkeilua, mutta toistokohta ei vaihdu klikattuun kohtaan.
4. Klikkaillaan toistokohdan säädintä toistokohdan vasemmalta puolelta.
5. Käy samoin kuin 3. kohdassa.
6. Tartutaan toistokohdan säätimestä kiinni ja raahataan sitä useita kertoja jonkin verran toistokohdasta eteenpäin.
7. Toisto siirtyy eri kohtaan kappaletta, mutta etenemissäädin ja nykyisen toistokohdan aika säilyy aiempana.
8. Kun äänitiedosto päättyy, ei osoitin ja toistokohdan aika ole vielä päässyt loppuun.
9. Ohjelma kaatuu ja konsoliin tulee teksti:

```
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00007f298547ab8e, pid=25338, tid=139815827322624
#
# JRE version: OpenJDK Runtime Environment (7.0_75-b13) (build 1.7.0_75-b13)
# Java VM: OpenJDK 64-Bit Server VM (24.75-b04 mixed mode linux-amd64 compressed oops)
# Derivative: IcedTea 2.5.4
# Distribution: Ubuntu 14.04 LTS, package 7u75-2.5.4-1~trusty1
# Problematic frame:
# C  [libc.so.6+0x98b8e]
#
# Failed to write core dump. Core dumps have been disabled. To enable core dumping, try "ulimit -c unlimited" before starting Java again
#
# An error report file with more information is saved as:
# /home/ad/fshome6/u6/y/ylhavuor/Linux/MusicMachine/MusicMachine/hs_err_pid25338.log
#
# If you would like to submit a bug report, please include
# instructions on how to reproduce the bug and visit:
#   http://icedtea.classpath.org/bugzilla
# The crash happened outside the Java Virtual Machine in native code.
# See problematic frame for where to report the bug.
#
------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
Total time: 3:05.046s
Finished at: Thu Feb 26 16:10:32 EET 2015
Final Memory: 4M/119M
------------------------------------------------------------------------
Failed to execute goal org.codehaus.mojo:exec-maven-plugin:1.2.1:exec (default-cli) on project MusicMachine: Command execution failed. Process exited with an error: 134 (Exit value: 134) -> [Help 1]

To see the full stack trace of the errors, re-run Maven with the -e switch.
Re-run Maven using the -X switch to enable full debug logging.

For more information about the errors and possible solutions, please read the following articles:
[Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

## Kelaaminen
1. Toistetaan [Toista tiedostoa normaalisti](#toista-tiedostoa-normaalisti)-kohdan vaiheet 1-4.
2. Klikkaillaan vimmatusti eteenpäin kelaus -painiketta.
3. Soiva äänitiedosto katkeilee, muttei juurikaan kelaudu.
4. Klikkaillaan vimmatusti taaksepäin kelaus -painiketta.
5. Käy samoin kuin kohdassa 3.

---
Seuraavat testit olen testannut ainoastaan omalla Macillani.

## Kelaaminen pitäen kelaus-painike pohjassa
1. Toistetaan [Toista tiedostoa normaalisti](#toista-tiedostoa-normaalisti)-kohdan vaiheet 1-4.
2. Klikataan eteenpäinkelaus-painiketta jättäen hiiren ykköspainike pohjaan.
3. Muutaman sekunnin päästä vapautetaan hiiren painike.
4. Soivassa äänitiedostossa on kuultavissa osassa testikokeiluista pieni toiston eteenpäin kelautuminen, mutta hiiren painalluksen aikana kelausta ei tapahdu (koodiin on toteutettu tähän toiminnallisuus).
5. Klikataan taaksepäinkelaus-painiketta jättäen hiiren ykköspainike pohjaan.
6. Muutaman sekunnin päästä vapautetaan hiiren painike.
7. Käy samoin kuin kohdassa 4.

## Valinnan poisto soittolistan äänitiedostoista
1. Toistetaan [Toista tiedostoa normaalisti](#toista-tiedostoa-normaalisti)-kohdan vaiheet 1-3.
2. Poistetaan valinta soittolistalta valitusta äänitiedostosta (Macilla cmd-näppäin pohjassa klikkaus).
3. Konsoliin ilmestyy bugista ilmoittava teksti:

```
Exception in thread "AWT-EventQueue-0" java.lang.ArrayIndexOutOfBoundsException: -1
	at java.util.Vector.elementData(Vector.java:734)
	at java.util.Vector.elementAt(Vector.java:477)
	at javax.swing.DefaultListModel.get(DefaultListModel.java:447)
	at musicmachine.ui.graphic.GraafinenKayttoliittyma.asetaTiedostoToistovalmiiksi(GraafinenKayttoliittyma.java:363)
	at musicmachine.ui.graphic.GraafinenKayttoliittyma.toistaPainikeActionPerformed(GraafinenKayttoliittyma.java:346)
	at musicmachine.ui.graphic.GraafinenKayttoliittyma.access$100(GraafinenKayttoliittyma.java:21)
	at musicmachine.ui.graphic.GraafinenKayttoliittyma$2.actionPerformed(GraafinenKayttoliittyma.java:99)
	at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2022)
	at javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2346)
	at javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:402)
	at javax.swing.DefaultButtonModel.setPressed(DefaultButtonModel.java:259)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(BasicButtonListener.java:252)
	at java.awt.AWTEventMulticaster.mouseReleased(AWTEventMulticaster.java:289)
	at java.awt.Component.processMouseEvent(Component.java:6525)
	at javax.swing.JComponent.processMouseEvent(JComponent.java:3321)
	at java.awt.Component.processEvent(Component.java:6290)
	at java.awt.Container.processEvent(Container.java:2234)
	at java.awt.Component.dispatchEventImpl(Component.java:4881)
	at java.awt.Container.dispatchEventImpl(Container.java:2292)
	at java.awt.Component.dispatchEvent(Component.java:4703)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4898)
	at java.awt.LightweightDispatcher.processMouseEvent(Container.java:4533)
	at java.awt.LightweightDispatcher.dispatchEvent(Container.java:4462)
	at java.awt.Container.dispatchEventImpl(Container.java:2278)
	at java.awt.Window.dispatchEventImpl(Window.java:2739)
	at java.awt.Component.dispatchEvent(Component.java:4703)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:746)
	at java.awt.EventQueue.access$400(EventQueue.java:97)
	at java.awt.EventQueue$3.run(EventQueue.java:697)
	at java.awt.EventQueue$3.run(EventQueue.java:691)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:86)
	at java.awt.EventQueue$4.run(EventQueue.java:719)
	at java.awt.EventQueue$4.run(EventQueue.java:717)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:716)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
	at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)
```
