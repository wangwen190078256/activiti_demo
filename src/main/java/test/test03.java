package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class test03 {



	//��������
	@Test
	public void test01() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRepositoryService().createDeployment().name("�������������").addClasspathResource("BizClaimVoucher.bpmn").addClasspathResource("BizClaimVoucher.png").deploy();

	}


	//��������
	@Test
	public void test02() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "���");
		processEngine.getRuntimeService().startProcessInstanceByKey("BizClaimVoucher",map);

	}


	//���ݴ����˲�ѯ��ص�����
	@Test
	public void test03() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		List<Task> list=processEngine.getTaskService().createTaskQuery().taskAssignee("��СС").list();
		for (Task task : list) {
			System.out.println("�������ƣ�"+task.getName());
			System.out.println("����ID��"+task.getId());
			System.out.println("����ʵ��ID��"+task.getProcessInstanceId());
		}


	}


	//Ա����������
	@Test
	public void test05() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "������");
		map.put("role", "manager");


		processEngine.getTaskService().complete("7503",map);


	}

	//���ž������
	@Test
	public void test06() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "��СС");
		map.put("rollback", "no");


		processEngine.getTaskService().complete("10002",map);


	}





}
