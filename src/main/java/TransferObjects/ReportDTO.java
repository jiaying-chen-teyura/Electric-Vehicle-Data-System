/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package TransferObjects;


import java.util.List;

/**
 * Data Transfer Object (DTO) that stores the complete report.
 * Contains EV data records and database metadata information.
 *
 * @author Chen Jiaying
 */
public class ReportDTO {
    private List<EVDTO> evs;
    private List<MetaDTO> metas;

    public List<EVDTO> getEvs() {
        return evs;
    }

    public void setEvs(List<EVDTO> evs) {
        this.evs = evs;
    }

    public List<MetaDTO> getMetas() {
        return metas;
    }

    public void setMetas(List<MetaDTO> metas) {
        this.metas = metas;
    }


    
    
}
