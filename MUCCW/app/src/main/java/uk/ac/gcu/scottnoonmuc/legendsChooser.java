package uk.ac.gcu.scottnoonmuc;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class legendsChooser {


    // *********************************************
    // Declare variables etc.
    // *********************************************

    private int iLegend;
    private int iMonth;
    private int iYear;
    private int iLegendAnswer;

    private String sLegend;
    private String sLegendInfo;
    private String[] saLegendsInfo;
    private String[] saLegend;
    private String sOutputMsg;

    // *********************************************
    // Declare getters and setters etc.
    // *********************************************

    private void setiLegend(int isLegend)
    {
        this.iLegend = isLegend;
    }

    public int getiLegend()
    {
        return iLegend;
    }

    private void setiMonth(int isMonth)
    {
        this.iMonth = isMonth;
    }

    public int getiMonth()
    {
        return iMonth;
    }

    private void setiYear(int isYear)
    {
        this.iYear = isYear;
    }
    public int getiYear()
    {
        return iYear;
    }

    private void setiLegendAnswer(int siLegendAnswer)
    {
        this.iLegendAnswer = siLegendAnswer;
    }
    public int getiLegendAnswer()
    {
        return iLegendAnswer;
    }

    private void setsLegend(int iDay)
    {
        this.sLegend = saLegend[iDay];
    }
    public String getsLegend()
    {
        return sLegend;
    }

    private void setsLegendInfo(int iPoemLine)
    {
        this.sLegendInfo = saLegendsInfo[iPoemLine];
    }
    public String getsLegendInfo()
    {
        return sLegendInfo;
    }

//list information on possible legends
    private void setSaLegendsInfo()
    {
        saLegendsInfo = new String[7];
        saLegendsInfo[0] = "Mary Queen of Scots is a prominent face in Scottish History, taking the throne at only 6 days old and becoming Queen consort of France for a year, before returning to Scotland and being imprisoned like Rapunzel – only a lot worse";
        saLegendsInfo[1] = "An all rounder; Scottish novelist, poet, essayist, and travel writer. A literary celebrity with a bushy moustache and countless notable publications. You’re the perfect match";
        saLegendsInfo[2] = "A Scottish poet regarded as an invaluable influence on Scottish literature, not to mentioning winning ‘greatest Scot’ in 2009 by the Scottish public in a vote run by STV. Also has a number of statues";
        saLegendsInfo[3] = "Doctor and suffragist, Elsie Inglis was most famous for her efforts and achievements in WWI. She worked on improving a number of epidemics in Serbia, and spent her life helping others";
        saLegendsInfo[4] = "Doctor and suffragist, Elsie Inglis was most famous for her efforts and achievements in WWI. She worked on improving a number of epidemics in Serbia, and spent her life helping others";
        saLegendsInfo[5] = "Or, as his mother called him, Charles Edward Louis John Casimir Sylvester Severino Maria Stuart. He unsuccessfully attempted to restore his family to the throne in 1745, and in 1759 he planned to invade Britain and that was unsuccessful too. Sorry";
        saLegendsInfo[6] = "A man we all have to thank for entertainment; Baird was the inventor of the first mechanical television. Baird was listed as one of the greatest Scottish scientists in history in 2006, in the National Library of Scotland’s Hall of Fame";
    }

    public String[] getSaLegendsInfo()
    {
        return saLegendsInfo;
    }
//list all names of possible legends
    private void setsaLegend()
    {
        saLegend = new String[7];
        saLegend[0] = "Mary Queen of Scots!";
        saLegend[1] = "Robert Louis Stevenson!";
        saLegend[2] = "Robert Burns!";
        saLegend[3] = "Elsie Inglis!";
        saLegend[4] = "Bonnie Prince Charlie!";
        saLegend[5] = "William Wallace!";
        saLegend[6] = "John Logie Baird!";
    }

    public String[] getsaLegend()
    {
        return saLegend;
    }

    private void setsOutputMsg(String sOutMsg)
    {
        this.sOutputMsg = sOutMsg;
    }
    public String getsOutputMsg()
    {
        return sOutputMsg;
    }

    // **************************************************
    // Declare constructor and date manipulation methods.
    // **************************************************
    public legendsChooser()
    {
        // Fill the legend answer
        setsaLegend();
        setSaLegendsInfo();
        // Use the Calendar to instantiate a calendar object for today's date
        Calendar cCal = Calendar.getInstance();
        // store the date, month, year
        setiLegend(cCal.get(Calendar.DAY_OF_WEEK));
        setiMonth(cCal.get(Calendar.MONTH));
        setiYear(cCal.get(Calendar.YEAR));
    }
    public legendsChooser(int vsLegend, int vsMonth, int vsYear)
    {
        // Fill the Legend+Info arrays
        setsaLegend();
        setSaLegendsInfo();
        // store the date, month, year
        setiLegend(vsLegend);
        setiMonth(vsMonth);
        setiYear(vsYear);
        // Use the GregorianCalendar to instantiate a calendar object for the Birthday
        GregorianCalendar gcBDay = new GregorianCalendar(vsYear,vsMonth, vsLegend);


        // Set the day of the week integer using the Birthday used to identify the legend
        setiLegendAnswer(gcBDay.get(Calendar.DAY_OF_WEEK)-1);        ;
        // Set the string for the Legend chosen
        setsLegend(getiLegendAnswer());
        // Set the information attached to the legend chosen
        setsLegendInfo(getiLegendAnswer());
        // Create temporary string for output message
        String sTempStr = "You are " + getsLegend() + "\n" +
                getsLegendInfo();
        setsOutputMsg(sTempStr);
    }

}
