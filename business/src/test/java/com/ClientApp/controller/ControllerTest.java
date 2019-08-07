package com.ClientApp.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ClientApp.models.ClientModel;

public class ControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getClientsTest() throws Exception {
		String uri = "/clients";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ClientModel[] clientList = super.mapFromJson(content, ClientModel[].class);
		assertTrue(clientList.length > 0);
		System.out.println("not tested");
	}

	@Test
	public void createClientTest() throws Exception {
		String uri = "/clients";
		ClientModel client = new ClientModel();
		client.setId(100L);
		client.setsocialReason("test");
		client.setIce("test");
		client.setPhone("0615363526");
		client.setAdresse("casa");
		client.setEmail("test@gmail.com");
		client.setCreatedAt(new Date());
		client.setUpdateAt(new Date());

		String inputJson = super.mapToJson(client);

		mvc.perform(MockMvcRequestBuilders.post("/clients/").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.socialReason", is("test"))).andExpect(jsonPath("$.ice", is("test")))
				.andExpect(jsonPath("$.phone", is("0615363526")));
	}

	@Test
	public void updateClientTest() throws Exception {

		ClientModel client = new ClientModel();
		client.setsocialReason("test2");
		client.setIce("test");
		client.setPhone("0615363526");
		client.setAdresse("casa");
		client.setEmail("test@gmail.com");
		client.setCreatedAt(new Date());

		String inputJson = super.mapToJson(client);
		mvc.perform(MockMvcRequestBuilders.put("/clients/{id}", 100L).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(143)))
				.andExpect(jsonPath("$.socialReason", is("test2"))).andExpect(jsonPath("$.ice", is("test")));

	}

	@Test
	public void updateClientErrorNotfoundTest() throws Exception {
		// when(service.findById(1L)).thenThrow(new ResourceNotFoundException(""));

		ClientModel client = new ClientModel();
		client.setsocialReason("test2");
		client.setIce("test");
		client.setPhone("0615363526");
		client.setAdresse("casa");
		client.setEmail("test@gmail.com");
		client.setCreatedAt(new Date());
		String inputJson = super.mapToJson(client);
		mvc.perform(put("/clients/{id}", 1555L).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isNotFound());

	}

	@Test
	public void deleteClientTest() throws Exception {
		String uri = "/clients/100";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}

}
