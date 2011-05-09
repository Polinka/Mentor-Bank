package ru.mentorbank.backoffice.services.moneytransfer;

//import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.mentorbank.backoffice.dao.OperationDao;
import ru.mentorbank.backoffice.dao.exception.OperationDaoException;
import ru.mentorbank.backoffice.model.Account;
import ru.mentorbank.backoffice.model.Operation;
import ru.mentorbank.backoffice.model.stoplist.JuridicalStopListRequest;
import ru.mentorbank.backoffice.model.transfer.JuridicalAccountInfo;
import ru.mentorbank.backoffice.model.transfer.PhysicalAccountInfo;
import ru.mentorbank.backoffice.model.transfer.TransferRequest;
import ru.mentorbank.backoffice.services.accounts.AccountService;
import ru.mentorbank.backoffice.services.accounts.AccountServiceBean;
import ru.mentorbank.backoffice.services.moneytransfer.exceptions.TransferException;
import ru.mentorbank.backoffice.services.stoplist.StopListService;
import ru.mentorbank.backoffice.services.stoplist.StopListServiceStub;
import ru.mentorbank.backoffice.test.AbstractSpringTest;
import static org.mockito.Mockito.*;

public class MoneyTransferServiceTest extends AbstractSpringTest {

	@Autowired
	private MoneyTransferServiceBean moneyTransferService;
	private JuridicalAccountInfo srcAccount;
	private JuridicalAccountInfo dstAccount;
	private TransferRequest transferRequest;
	private Operation Op;
	private Account srcAccOp;
	private Account dstAccOp;
	
	@Before
	public void setUp() {
		srcAccount = new JuridicalAccountInfo();
 	    dstAccount = new JuridicalAccountInfo();
 	    transferRequest = new TransferRequest();
 	    
 	    srcAccount.setAccountNumber("111111");
 	    srcAccount.setInn(StopListServiceStub.INN_FOR_OK_STATUS);
 	    
 	    dstAccount.setAccountNumber("222222");
 	    dstAccount.setInn(StopListServiceStub.INN_FOR_OK_STATUS);
 	    
 	    transferRequest.setSrcAccount(srcAccount);
 	    transferRequest.setDstAccount(dstAccount);
 	    
 	    Operation Op = new Operation();
 	    srcAccOp = new Account();
        dstAccOp = new Account();
        srcAccOp.setAccountNumber("111111");
        dstAccOp.setAccountNumber("222222");
        Op.setSrcAccount(srcAccOp);
        Op.setDstAccount(dstAccOp);
 	    
 	    //mockedStopListService = mock(StopListServiceStub.class);
 	    //mockedAccountService = mock(AccountServiceBean.class);
 	    //when(mockedAccountService.verifyBalance(srcAccount)).thenReturn(true);
 	    //when(mockedAccountService.verifyBalance(dstAccount)).thenReturn(true);
 	    //moneyTransferService.setAccountService(mockedAccountService);
	}
	@Test
	public void transfer() throws TransferException, OperationDaoException {
		setUp();
		// TODO: Необходимо протестировать, что для хорошего перевода всё
		// работает и вызываются все необходимые методы сервисов
		// Далее следует закоментированная закотовка
		StopListService mockedStopListService = mock(StopListServiceStub.class);
		AccountService mockedAccountService = mock(AccountServiceBean.class);
		OperationDao mockedOp = mock(OperationDao.class);
		
		moneyTransferService.transfer(transferRequest);
		
		verify(mockedStopListService).getJuridicalStopListInfo(any(JuridicalStopListRequest.class));
		verify(mockedAccountService).verifyBalance(srcAccount);
		verify(mockedOp).saveOperation(Op);
	}
}
