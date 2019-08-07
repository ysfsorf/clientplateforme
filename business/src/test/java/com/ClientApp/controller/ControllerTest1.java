package com.ClientApp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ClientApp.UnitTestUtil;

import com.ClientApp.controller.*;
import com.ClientApp.exception.ResourceNotFoundException;
import com.ClientApp.models.ClientModel;
import com.ClientApp.services.ClientService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=Controller.class,secure = false)
public class ControllerTest1 {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientService clientService;

	@Test
	public void findallClient() throws Exception{
		   ClientModel firstClient = new ClientModel("entr1","1","rabat","0681136737","entr1@gmail.com");
		   firstClient.setId(1L);
		   ClientModel secondClient = new ClientModel("entr2","2","casa","0681136737","entr2@gmail.com");
           secondClient.setId(2L);
		   when(clientService.getAll()).thenReturn(Arrays.asList(firstClient, secondClient));
		   
	        mockMvc.perform(get("/clients")  .contentType(UnitTestUtil.APPLICATION_JSON_UTF8)
	                )
	                .andExpect(status().isOk())
	                
	                .andExpect(jsonPath("$",Matchers.hasSize(2)))
	                .andExpect(jsonPath("$[0].id", is(1)))
	                .andExpect(jsonPath("$[0].socialReason", is("entr1")))
	                .andExpect(jsonPath("$[0].ice", is("1")))
	                .andExpect(jsonPath("$[0].adresse", is("rabat")))
	                .andExpect(jsonPath("$[0].phone", is("0681136737")))
	                .andExpect(jsonPath("$[0].email", is("entr1@gmail.com")))
	                .andExpect(jsonPath("$[1].id", is(2)))
                    .andExpect(jsonPath("$[1].socialReason", is("entr2")))
                    .andExpect(jsonPath("$[1].ice", is("2")))
                    .andExpect(jsonPath("$[1].adresse", is("casa")))
                    .andExpect(jsonPath("$[1].phone", is("0681136737")))
                    .andExpect(jsonPath("$[1].email", is("entr2@gmail.com")));
          
	              
	        verify(clientService, times(1)).getAll();
	        verifyNoMoreInteractions(clientService);
		
	
	}
	@Test
	public void findByName() throws Exception {
		ClientModel client = new ClientModel();
		client.setId(1L);
		client.setsocialReason("entre1");
		client.setIce("1");
		client.setAdresse("rabat");
		client.setPhone("0681136737");
		client.setEmail("entr1@gmail.com");
		
		String expectedJson = this.mapToJson(client);
		
		Mockito.when(clientService.get(Mockito.anyString())).thenReturn(client);
		
		String URI = "clients/entre1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		
		System.out.println(outputInJson+expectedJson);
		assertThat(outputInJson).isEqualTo(expectedJson);
	
	}
	
	@Test
	public void findByIdTest() throws Exception {
		
		when(clientService.findById(187L)).thenThrow(new ResourceNotFoundException(""));
		 
        mockMvc.perform(get("/clients/{id}", 187L))
                .andExpect(status().isNotFound());
 
        verify(clientService, times(1)).findById(1L);
        verifyNoMoreInteractions(clientService);
    }
		
		
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	
	

}
