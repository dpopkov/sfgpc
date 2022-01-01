package learn.sfg.sfgpc.controllers;

import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testListOfOwners() throws Exception {
        Set<Owner> owners = Set.of(
                Owner.builder().id(1L).lastName("Doe").build(),
                Owner.builder().id(2L).lastName("Smith").build());
        given(ownerService.findAll()).willReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(model().attribute("owners", hasSize(2)))
                .andExpect(view().name("owners/index"))
                .andExpect(status().isOk());
        then(ownerService).should().findAll();
    }

    @Test
    void testNotImplemented() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(view().name("notimplemented"))
                .andExpect(status().isOk());
        then(ownerService).shouldHaveNoInteractions();
    }
}
