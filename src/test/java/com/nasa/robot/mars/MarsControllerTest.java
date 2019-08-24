package com.nasa.robot.mars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MarsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveCaminhar2x0xS() throws Exception {
        mvc.perform(post("/rest/mars/MMRMMRMM")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void deveCaminhar0x2xW() throws Exception {
        mvc.perform(post("/rest/mars/MML")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void deveCaminharNaoGuardarEstado() throws Exception {
        mvc.perform(post("/rest/mars/MML")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));

        mvc.perform(post("/rest/mars/MML")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void naoDeveAceitarPassosInstrucaoInvalida() throws Exception {
        mvc.perform(post("/rest/mars/AAA")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void naoDeveAceitarPassos() throws Exception {
        mvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}