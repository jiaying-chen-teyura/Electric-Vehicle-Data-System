package Run;

import BusinessLogic.EVBusinessLogic;
import BusinessLogic.PostcodeBusineesLogic;
import TransferObjects.EVDTO;
import TransferObjects.PostcodeDTO;
import java.util.ArrayList;
import java.util.List;


/**
 * Entry point for the Electric Vehicle reporting application.
 *
 * <p>This class retrieves electric vehicle and postal code data through
 * the business layer and displays formatted reports to the console.</p>
 *
 * @author Chen Jiaying
 */
public class Launcher{
    
    /**
     * Starts the application.
     *
     * <p>Retrieves electric vehicle data, displays a report containing
     * electric vehicle counts by FSA displays
     * postal code information for Algonquin College, and closes the
     * database connection before terminating.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String args[]){
        
        EVBusinessLogic evLogic = new EVBusinessLogic();
        PostcodeBusineesLogic pcLogic = new PostcodeBusineesLogic();
        String queryFsa = "K2G";
        
        List<EVDTO>  evs = evLogic.getAllEvs();
        printReport(evs);
        
        PostcodeDTO pcDTO = pcLogic.getPostcodeByFsa(queryFsa);
        printPostcode(pcDTO);
        
        DataAccessLayer.DataSource.closeConnection();
    }
    
    /**
     * Displays a formatted report of electric vehicle records and summary
     * totals.
     *
     * @param evs the list of electric vehicle records to display
     */
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
     * Prints the summary totals for the report.
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
    
    /**
     * Displays postal code information for a FSA.
     *
     * @param pcDTO the postal code data transfer object to display
     */
           
    private static void printPostcode(PostcodeDTO pcDTO){
        System.out.println("");
        System.out.println("FSA for Algonquin College: ");
        System.out.printf("%-6s %-68s %-16s %-16s %-16s\n",
                            "Fsa","City", "Province", "Latitude",
                            "Longitude");
        
        System.out.printf("%-6s %-68s %-16s %-16f %-16f\n",
                           
                           pcDTO.getFsa(),
                           pcDTO.getCity(),
                           pcDTO.getProvince(),
                           pcDTO.getLatitude(),
                           pcDTO.getLongitude());
                           
    }
}