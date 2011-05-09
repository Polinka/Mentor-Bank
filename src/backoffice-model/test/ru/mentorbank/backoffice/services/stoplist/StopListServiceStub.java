package ru.mentorbank.backoffice.services.stoplist;

import ru.mentorbank.backoffice.model.stoplist.JuridicalStopListRequest;
import ru.mentorbank.backoffice.model.stoplist.PhysicalStopListRequest;
import ru.mentorbank.backoffice.model.stoplist.StopListInfo;
import ru.mentorbank.backoffice.model.stoplist.StopListStatus;
import ru.mentorbank.backoffice.services.stoplist.StopListService;

public class StopListServiceStub implements StopListService {

	public static final String INN_FOR_OK_STATUS = "1111111111111";
	public static final String INN_FOR_STOP_STATUS = "22222222222222";
	public static final String INN_FOR_ASKSECURITY_STATUS = "33333333333333";
	public static final String DNUM_FOR_OK_STATUS = "111";
    public static final String DNUM_FOR_STOP_STATUS = "222";
    public static final String DSER_FOR_OK_STATUS = "1111";
    public static final String DSER_FOR_STOP_STATUS = "2222";
    public static final String FNAM_FOR_OK_STATUS = "Max";
    public static final String FNAM_FOR_STOP_STATUS = "Pol";
    public static final String LNAM_FOR_OK_STATUS = "Smith";
    public static final String LNAM_FOR_STOP_STATUS = "Green";
    public static final String MNAM_FOR_OK_STATUS = "Homer";
    public static final String MNAM_FOR_STOP_STATUS = "John";
    public static final String ANUM1 = "1111111111111";
    public static final String ANUM2 = "2222222222222";

	@Override
	public StopListInfo getJuridicalStopListInfo(
			JuridicalStopListRequest request) {
		StopListInfo stopListInfo = new StopListInfo();
		stopListInfo.setComment("Комментарий");
		if (INN_FOR_OK_STATUS.equals(request.getInn())){			
			stopListInfo.setStatus(StopListStatus.OK);
		} else if (INN_FOR_STOP_STATUS.equals(request.getInn())) {
			stopListInfo.setStatus(StopListStatus.STOP);			
		} else {
			stopListInfo.setStatus(StopListStatus.ASKSECURITY);			
		}
		return stopListInfo;
	}

	@Override
	public StopListInfo getPhysicalStopListInfo(PhysicalStopListRequest request) {
		StopListInfo stopListInfo = new StopListInfo();
        stopListInfo.setComment("Комментарий");
        if (FNAM_FOR_OK_STATUS.equals(request.getFirstname())
        		&& LNAM_FOR_OK_STATUS.equals(request.getLastname())
        		&& MNAM_FOR_OK_STATUS.equals(request.getMiddlename()) 
        		&& DNUM_FOR_OK_STATUS.equals(request.getDocumentNumber()) 
        		&& DSER_FOR_OK_STATUS.equals(request.getDocumentSeries())) {
            stopListInfo.setStatus(StopListStatus.OK);
        } else if (FNAM_FOR_STOP_STATUS.equals(request.getFirstname()) 
        		&& LNAM_FOR_STOP_STATUS.equals(request.getLastname())
        		&& MNAM_FOR_STOP_STATUS.equals(request.getMiddlename()) 
        		&& DNUM_FOR_STOP_STATUS.equals(request.getDocumentNumber()) 
        		&& DSER_FOR_STOP_STATUS.equals(request.getDocumentSeries())) {
            stopListInfo.setStatus(StopListStatus.STOP);
        } else {
            stopListInfo.setStatus(StopListStatus.ASKSECURITY);
        }
        return stopListInfo;
		//TODO: Реализовать
	}

}
