package example;

import java.util.UUID;

import ecpay.invoice.integration.AllInOne;
import ecpay.invoice.integration.domain.AllowanceInvalidObj;
import ecpay.invoice.integration.domain.AllowanceObj;
import ecpay.invoice.integration.domain.CheckLoveCodeObj;
import ecpay.invoice.integration.domain.CheckMobileBarCodeObj;
import ecpay.invoice.integration.domain.DelayIssueObj;
import ecpay.invoice.integration.domain.InvoiceNotifyObj;
import ecpay.invoice.integration.domain.IssueInvalidObj;
import ecpay.invoice.integration.domain.IssueObj;
import ecpay.invoice.integration.domain.QueryAllowanceInvalidObj;
import ecpay.invoice.integration.domain.QueryAllowanceObj;
import ecpay.invoice.integration.domain.QueryIssueInvalidObj;
import ecpay.invoice.integration.domain.QueryIssueObj;
import ecpay.invoice.integration.domain.TriggerIssueObj;

public class ExampleInvoice {
	public static AllInOne all;
	public static void main(String[] args){
		initial();
		System.out.println("Issue: "+postIssue());
		System.out.println("DelayIssue: "+postDelayIssue());
		System.out.println("TriggerIssue: "+postTriggerIssue());
		System.out.println("Allowance: "+postAllowance());
		System.out.println("IssueInvalid: "+postIssueInvalid());
		System.out.println("AllowanceInvalid: "+postAllowanceInvalid());
		System.out.println("QueryIssue: "+postQueryIssue());
		System.out.println("QueryAllowance: "+postQueryAllowance());
		System.out.println("QueryIssueInvalid: "+postQueryIssueInvalid());
		System.out.println("QueryAllowanceInvalid: "+postQueryAllowanceInvalid());
		System.out.println("InvoiceNotify: "+postInvoiceNotify());
		System.out.println("CheckMobileBarCode: "+postCheckMobileBarCode());
		System.out.println("CheckLoveCode: "+postCheckLoveCode());
	}
	
	private static void initial(){
		all = new AllInOne();
	}
	
	public static String postIssue(){
		IssueObj obj = new IssueObj();
		UUID uid = UUID.randomUUID();
		obj.setRelateNumber(uid.toString().replaceAll("-", "").substring(0, 30));
		obj.setCustomerName("Mark");
		obj.setCustomerAddr("Taiwan");
		obj.setCustomerPhone("0912345678");
		obj.setPrint("1");
		obj.setDonation("2");
		obj.setTaxType("1");
		obj.setSalesAmount("100");
		obj.setItemName("�B�ʥΫ~");
		obj.setItemCount("1");
		obj.setItemWord("�c");
		obj.setItemPrice("100");
		obj.setItemAmount("100");
		return all.issue(obj);
	}
	
	public static String postDelayIssue(){
		DelayIssueObj obj = new DelayIssueObj();
		obj.setRelateNumber("sdflfjwklekj");
		obj.setCustomerName("Mark");
		obj.setCustomerAddr("Taiwan");
		obj.setCustomerPhone("0912345678");
		obj.setPrint("1");
		obj.setDonation("2");
		obj.setTaxType("1");
		obj.setSalesAmount("100");
		obj.setItemName("�B�ʥΫ~");
		obj.setItemCount("1");
		obj.setItemWord("�c");
		obj.setItemPrice("100");
		obj.setItemAmount("100");
		obj.setDelayFlag("1");
		obj.setDelayDay("7");
		obj.setTsr("sdfowijl2khj");
		return all.delayIssue(obj);
	}
	
	public static String postTriggerIssue(){
		TriggerIssueObj obj = new TriggerIssueObj();
		obj.setTsr("sdflfkjwlekfholih");
		return all.triggerIssue(obj);
	}
	
	public static String postAllowance(){
		AllowanceObj obj = new AllowanceObj();
		obj.setInvoiceNo("XN12345678");
		obj.setAllowanceNotify("A");
		obj.setCustomerName("Mark");
		obj.setNotifyMail("abc@opay.com.tw");
		obj.setNotifyPhone("0912345678");
		obj.setAllowanceAmount("90");
		obj.setItemName("�B�ʥΫ~");
		obj.setItemCount("1");
		obj.setItemWord("�c");
		obj.setItemPrice("90");
		obj.setItemAmount("90");
		return all.allowance(obj);
	}
	
	public static String postIssueInvalid(){
		IssueInvalidObj obj = new IssueInvalidObj();
		obj.setInvoiceNumber("XN12345678");
		obj.setReason("�岫");
		return all.issueInvalid(obj);
	}
	
	public static String postAllowanceInvalid(){
		AllowanceInvalidObj obj = new AllowanceInvalidObj();
		obj.setInvoiceNo("XN12345678");
		obj.setAllowanceNo("1234123412341234");
		obj.setReason("����");
		return all.allowanceInvalid(obj);
	}
	
	public static String postQueryIssue(){
		QueryIssueObj obj = new QueryIssueObj();
		obj.setRelateNumber("sdjfklkwjegoihoi");
		return all.queryIssue(obj);
	}
	
	public static String postQueryAllowance(){
		QueryAllowanceObj obj = new QueryAllowanceObj();
		obj.setInvoiceNo("TT00012440");
		obj.setAllowanceNo("2017063010319868");
		return all.queryAllowance(obj);
	}
	
	public static String postQueryIssueInvalid(){
		QueryIssueInvalidObj obj = new QueryIssueInvalidObj();
		obj.setRelateNumber("sdfwhifueifhldiohf");
		return all.queryIssueInvalid(obj);
	}
	
	public static String postQueryAllowanceInvalid(){
		QueryAllowanceInvalidObj obj = new QueryAllowanceInvalidObj();
		obj.setInvoiceNo("TU00005705");
		obj.setAllowanceNo("2017052311296404");
		return all.queryAllowanceInvalid(obj);
	}
	
	public static String postInvoiceNotify(){
		InvoiceNotifyObj obj = new InvoiceNotifyObj();
		obj.setInvoiceNo("XN12345678");
		obj.setAllowanceNo("Allpay0123456789");
		obj.setPhone("0912345678");
		obj.setNotifyMail("abc@ecpay.com");
		obj.setNotify("A");
		obj.setInvoiceTag("I");
		obj.setNotified("A");
		return all.invoiceNotify(obj);
	}
	
	public static String postCheckMobileBarCode(){
		CheckMobileBarCodeObj obj = new CheckMobileBarCodeObj();
		obj.setBarCode("/6G+X3LQ");
		return all.checkMobileBarCode(obj);
	}
	
	public static String postCheckLoveCode(){
		CheckLoveCodeObj obj = new CheckLoveCodeObj();
		obj.setLoveCode("X123456");
		return all.checkLoveCode(obj);
	}
}
