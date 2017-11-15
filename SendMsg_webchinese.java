package cn.shmily.util;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * ���ŷ��͹�����
 * @author 93449
 *
 */
public class SendMsg_webchinese {

	public static void main(String[] args)throws Exception{

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//��ͷ�ļ�������ת��
		NameValuePair[] data ={ new NameValuePair("Uid", "shmily_wen"),new NameValuePair("Key", "59e769b746c5428f41c1"),new NameValuePair("smsMob","18889832911"),new NameValuePair("smsText","��֤�룺8888")};
		post.setRequestBody(data);
		
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println("result:	"+result); //��ӡ������Ϣ״̬


		post.releaseConnection();

	}

}