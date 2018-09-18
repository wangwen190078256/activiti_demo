package test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class test02 {





	//��������
	@Test
	public void test01() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRepositoryService().createDeployment().name("�������������").addClasspathResource("MyProcess.bpmn").addClasspathResource("MyProcess.png").deploy();

	}


	//��������
	@Test
	public void test02() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");

	}


	//���ݴ����˲�ѯ��ص�����
	@Test
	public void test03() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		List<Task> list=processEngine.getTaskService().createTaskQuery().taskAssignee("��ΰ��").list();
		for (Task task : list) {
			System.out.println("����ID��"+task.getId());//15004
			System.out.println("����ʵ��ID��"+task.getProcessInstanceId());//15001
		}


	}


	//������񣨵��ʽܣ�
	@Test
	public void test04() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getTaskService().complete("15004");//7502


	}

	//���������Ԫ����
	@Test
	public void test05() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getTaskService().complete("17502");


	}

	//��������ʵ��ID  �鿴��Ӧ������ʵ��
	@Test
	public void test06() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		ProcessInstance processInstance=processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId("15001").singleResult();
		
		System.out.println(processInstance.getDeploymentId());
		System.out.println(processInstance.getName());
		System.out.println(processInstance.getId());
		
	}

	
	


}
