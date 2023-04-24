import java.util.*;
import java.io.*;

public class Main {

////////////////////////////////////////////////////////////////////
// main method
////////////////////////////////////////////////////////////////////
public static void main(String[] args) {

EventQueue eventQueue=new EventQueue();
Event event;

// Java constant holding the largest positive 
// finite value of type double
double minAllDoneTime=Double.MAX_VALUE;

double eventTime;
String eventType;
String junk;
int eventNumItems;
final int impossibleNumItemsValue=-1;
boolean debug=true;

StringTokenizer tokenizer;
int ct=0;

if(args.length!=1)
{
System.out.println("Incorrect number of arguments: " + args.length + " supplied, 1 needed");
System.out.println("Usage: required argments are " + " jpeg filename ");
System.out.println("java Main little_ass3_events2018.txt");
System.out.println("java Main ass3_events2018.txt");
System.out.println("java Main noAllDone_ass3_events2018.txt");
System.exit(0);
}



InStringFile eventFileReader=new InStringFile(args[0]);

do {
ct++;
String fileLine = eventFileReader.read();
// read token "Time:" first into junk, ignore this
tokenizer=new StringTokenizer(fileLine);
junk=tokenizer.nextToken();
// read the time next as astring and parse it unto a double
eventTime=Double.parseDouble(tokenizer.nextToken());
// read "Type:" first into junk and ignore it
junk=tokenizer.nextToken();
// read eventType as string
eventType=tokenizer.nextToken();

if(!(eventType.equals("SNAPSHOT") || eventType.equals("ALL_DONE")))
    {
    // read "Num:" first into junk and ignore it
    junk=tokenizer.nextToken();
    // read eventNumItems as integer
    eventNumItems=Integer.parseInt(tokenizer.nextToken());
    }
else
    {
    eventNumItems=impossibleNumItemsValue;
    }
// Main the minimum ALL_DONE time
if(eventType.equals("ALL_DONE")) 
   if(minAllDoneTime > eventTime) minAllDoneTime=eventTime;

if(eventNumItems!=impossibleNumItemsValue)
  System.out.format("%3d  Time: %7.2f Type: %-12s Number of items: %d\n",
                      ct,eventTime,eventType,eventNumItems);
else
  System.out.format("%3d  Time: %7.2f Type: %-12s\n",ct,eventTime,eventType);

event=new Event(eventTime,eventType,eventNumItems);
eventQueue.insertEvent(event,debug);

} while (!eventFileReader.endOfFile());

System.out.println("\n" + ct + 
                   " events read and inserted in order in the eventQueue");

if(minAllDoneTime==Double.MAX_VALUE)
  {
  System.out.println("\nNo ALL_DONE event -  program terminates in Main.java\n\n");
  System.exit(1);
  }
else eventQueue.deleteEvents(minAllDoneTime,debug);
}

}
