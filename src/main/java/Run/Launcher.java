/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/

package Run;

import BusinessLogic.EVBusinessLogic;
import TransferObjects.EVDTO;
import java.util.ArrayList;
import java.util.List;


/**
 * Application entry point.
 *
 * Retrieves Electric Vehicle (EV) data from the business layer and
 * displays a formatted report to the console.
 * 
 * @author Chen Jiaying
 */
public class Launcher{
    
    /**
     * Launcher method that starts the application.
     *
     * @param args command-line arguments(not used)
     */
    public static void main(String args[]){
        
        EVBusinessLogic evLogic = new EVBusinessLogic();
        
        List<EVDTO>  evs = evLogic.getAllEvs();
        printReport(evs);
        
        
    }
    

    private static void printReport(List<EVDTO> evs){
        System.out.println("EV Counts for Ontario ");
        System.out.printf("%-6s %-67s %-6s "
                            + "%-6s %-6s\n",
                          "FSA","City", "BEV", "PHEV", "TotalEv");

        for(EVDTO ev : evs){
            printEV(ev);
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------");
        printTotals(calculateSum(evs));
    }
    
    /**
     * Calculates total values for BEVs, PHEVs, and all EVs.
     *
     * @param evs list of EV records
     * @return list containing:
     *         <ul>
     *         <li>Index 0 = Total BEVs</li>
     *         <li>Index 1 = Total PHEVs</li>
     *         <li>Index 2 = Total EVs</li>
     *         </ul>
     */
    private static List<Integer> calculateSum(List<EVDTO> evs){
        int bevTotal = 0;
        int phevTotal = 0;
        int totalEVTotal = 0;
        List<Integer> totals = new ArrayList<>();
        
        for (EVDTO ev : evs){
            bevTotal+=ev.getBev();
            phevTotal+=ev.getPhev();
            totalEVTotal+=ev.getTotalEv();
        }
        totals.add(bevTotal);
        totals.add(phevTotal);
        totals.add(totalEVTotal);
        
        return totals;
    }
    
    
    /**
     * Prints a formatted EV record.
     *
     * @param ev EV data object to display
     */
    private static void printEV(EVDTO ev){
        System.out.printf("%-6s %-67s %-6d "
                            + "%-6d %-6d\n"
                            , ev.getFsa(),ev.getCity()
                            ,ev.getBev(), ev.getPhev()
                            ,ev.getTotalEv());
    }
    
    /**
     * Prints summary totals for the report.
     *
     * @param totals list containing total values for BEVs,
     *               PHEVs, and total EVs
     */
    private static void printTotals(List<Integer> totals){

        System.out.printf("%-74s %-6d %-6d %-6d\n",
                           "Total" ,
                           totals.get(0),
                           totals.get(1),
                           totals.get(2));
    }
}