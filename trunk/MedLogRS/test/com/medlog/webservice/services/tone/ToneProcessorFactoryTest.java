/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.vo.DiaryVO;
import com.medlog.webservice.vo.PatientVO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author westy
 */
public class ToneProcessorFactoryTest {

    DbConnection dbc = null;

    public ToneProcessorFactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbc = new DbConnection();
    }

    @After
    public void tearDown() {
        dbc.close();
    }

    /**
     * Test of execute method, of class ToneProcessorFactory.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Random r = new Random();
        Integer[] v = {r.nextInt(9) + 1, r.nextInt(9) + 1};
        final String JOURNAL_HAPPY = "I liked last Friday. It was a really nice day. At least for five reasons:\n"
                + "\n"
                + "-) one: yesterday we learnt that our boss liked the programme very much and there are huge changes that very soon the radio youth will set sail on the air. The revolution is to begin I shall say. New comes… winds of change… etc. Inside me I am happy as a child. I could contemplate this news since yesterday morning. On Friday I was too tired – I ate KFC supper and went to bed.\n"
                + "\n"
                + "Two, I took the ID photograph – I look quite handsome and I did not smile stupiditly this time. So all the formalities are done. If everything goes well, I will have my new identity card soon.\n"
                + "\n"
                + "Three,I have a new Playboy. Some things to read and of course the new playmate. After boring Kayah there’s something to look at.\n"
     
                + "Four, I did about 30 kilometers on my bike. no injuries, no side effects and I avoided two hits – some idiots tried to overtake me driving a few centimeters from me. And I visited my sister – it’s always a pleasant thing. The kids were a bit nasty, but this is normal. My sister is learning to drive and I think she has swallowed the bug. I hope that very soon she will have a chance to hit her brother on a bike.\n"
            
                + "Five (the most important agas): finaly I met Joanne. Three weeks of postponig, but at last we made it. And it was so nice. It does not matter that I had to wait for almost an hour (she had a good excuse) – it was worth it. At lest I read half of the book. First we sat on a bench in the library, then we went for quite a long walk… lots of talking. It is really nice to spend some time with beautiful, smiled and talking a lot girl. I have no idea what is going to happen now, but I am not thinking about it now. She will have to give me back the photos and CD’s. and that’s optimistic for me.\n"
                + ". I would add listetning to new Annie Lennox. This is top class music. A beautiful thing, especially in the evening – the sounds fill in my small room fantastic. Comparing with Annie, new Madonna is so pale. ";
        String KILLER__JOURNAL ="\n" +
"In my lifetime I have murdered 21 human beings,I have co~nitted thousands of burglaries,\n" +
"robberies.1~rcenIe8.\n" +
"arson~~nd last but not least I have connitted Bodomy on more than luOO~uman 'beings.\n" +
"For all of these things I am not the least bit sorry.I have no conscience so that does not worry me.\n" +
"I don't believe in man,God,.nor devil.\n" +
"I hate the Vlhole darned human race \"including myself.\n" +
"my 145 page autobiography I st~ted the fact that 1n 1921 1n Lqblto Bay,\n" +
"Africa,I there killed 6 niggers.I merely stated the bare fact.To Bome people o~ average intelligence this seems an almost impossible feet.\n" +
"That is because of their ignorance of the ,full detalls.\n" +
"It was very much easier-for me to kill th~se_6ix:niggers than it \n" +
"was for me to kill any une of the 7  \n" +
"young boys I ~illed later and some of the~were only 11 or 12 years old.,l'In Africa there are bull buffaloes thet weigh 2000 pounda and \n" +
"have enormous strength,yet a crocadile 12 or 15 foot long can kill I and eat a buffalo.\n" +
"Any ~f these 6 niggers that 1 killed could kill. I stone of those crocadiles.\n" +
"Armned with no more than aone small ,piece of  rotten meat they do that trick every day all I 0M r tfrica -1 waS fore~rmed with the :nowled~e that 1 had ~ained i an la SO a ~ mllamete~ Ger-Dan L,l\"\"$r Auto,n2tic-Pintol and plenty of  The seven of us were in the canoe,\n" +
"t.he other six In rz-ont,of me where I sat in the stern.\n" +
"The canoe was ebout 22 foot long 42 foot wide and 2 1/2 foot deep!\n" +
"The niggers expected nothing. They all had their backs turned to me.I a~ a crack shot.I fired Ii single shot into each nie,ers back,\n" +
"and then reloaded with a new clip and fired another shot lnto the brain of each one as they lay dying or dead in the botto~\n" +
"of the canoe.Thep I threw them allover board and the crocadiles soon finished whst I had left for  them. This canoe was registered and licensed. It must still be in existence. If it is, there are two bullets imbedded in the wood,\n" +
"one in the bottom near the stern and  one on Hie port side near the middle.Tnese ni, er-swere all full grown men with fa:ullies who must be still alive and who still remeaoer me as dozens of people saw me at Lobito Bay when I hired them and their canoe.\n" +
"The exact date can be very easily ascertain-ed by the records of the port and the O&8Sengers list or the s~ll Belgian S. s. which runs from ~atidi to Bo~a;\n" +
"Loanda and Lcbito Bay and return. On her 1n 1921 I bought a ticket froll Loanda to Lobito Bay and a few days x~kex in Lobito Bay snd then I bou~ht a return ticket on the sane bOat to Loanda.\n" +
"\n" +
"\n" +
"Shop was a very ingenious contrivance for inflicting the worst punishment where it vouLd do tho least harm and the most good. They used to h~ve a large ~ooden block which we were bent over and tied face downward after first being stripped naked. Then a large towel was soaked in sqlt water and spread on our backs ~rom the shoulders do~m to the knees. Then the man who was to do the ,whipping took a large strap about ~ of an inch think by 4 inches wide and  about t~o reet long with a handle on it nbaut two feet long. This strap had a lot of little round holes punched through it. Every time that whip came down on the body the skin would come up through these little holes in the strap and a~ter 25 or 30 times of this,little blister~\n" +
"would form and then burst,\n" +
"and right there and then hell began.";
        
        List<Integer> vals = Arrays.asList(v);
        Collections.shuffle(vals);
//        Math.ceil(Math.random()*10+1)%10
        DiaryVO vo = DiaryVO.builder().mood(vals.get(0)).productivity(vals.get(1)).notes("asdf").patientID(PatientVO.builder().patientID(2).build()).build();
        String expResult = "";
        String result = ToneProcessorFactory.execute(dbc, vo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
