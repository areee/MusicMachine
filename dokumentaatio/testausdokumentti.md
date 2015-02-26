# Testausdokumentti

## Toista tiedostoa normaalisti (Ubuntu/Linux)
1. Käynnistetään ohjelma.
2. Valitaan käyttöliittymäksi graafinen käyttöliittymä.
3. Lisätään musiikkitiedosto plus-painikkeesta.
4. Klikataan toista-painiketta.
5. Kuunnellaan äänitiedosto loppuun asti.
6. Ohjelman ylälaidassa näkyvä "Toistetaan..." -teksti ei vaihdu, vaikka ohjelman toisto on päättyt. Samoin toista-painikkeessa on edelleen pause-kuvake, vaikka ohjelman toisto on päättynyt.
7. Klikataan pysäytä-painiketta.
8. Konsoliin ilmestyy virheviesti "Exception in thread "AWT-EventQueue-0" java.lang.IllegalStateException: Line not open – –".
9. Toista-painike ei vaihdu takaisin play-kuvakkeeksi, vaikka näin pitäisi tapahtua.

- Vastaavaa ongelmaa ei esiinny Macilla.

## Valitse tiedoston toistokohta toistokohdan säätimellä (Ubuntu/Linux)
1. Toistetaan edellisen testin vaiheet 1-4.
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

- Tässäkin tapauksessa vastaavaa ongelmaa ei esiinny Macilla.

## Kelaaminen (Ubuntu/Linux)
1. Toistetaan edellisen testin vaiheet 1-4.
2. Klikkaillaan vimmatusti eteenpäin kelaus -painiketta.
3. Soiva äänitiedosto katkeilee, muttei juurikaan kelaudu.
4. Klikkaillaan vimmatusti taaksepäin kelaus -painiketta.
5. Sama kuin kohdassa 3.

- Sama ongelma esiintyi myös Macilla, tosin koodia hienosäätämällä tuosta ongelmasta pääsi jossain määrin jo eroon.

