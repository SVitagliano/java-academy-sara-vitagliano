package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import com.academy.cic.entity.Apartment;
import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;

public class ServiceTest {

private static Dao dao;
	
	private static Service service;
	
	@BeforeAll
	static void init() {
		// creazione mock dao
		dao = Mockito.mock(Dao.class);
		service = new Service(dao);
	}
	
	@Test
    void testRateApartment_WithAreaZero() throws EntityNotFoundException  {
        Apartment apartment = new Apartment(0, BigDecimal.valueOf(50000.0));
        Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
        int result =service.rateApartment(1);
        assertEquals(-1, result);
    }
	
	@Test
    void testRateApartment_WithCheapThreshold() throws EntityNotFoundException {
        Apartment apartment = new Apartment(50.0, BigDecimal.valueOf(30000.0));
        Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
        int result = service.rateApartment(1);
        assertEquals(0, result); 
    }
	
	@Test
	void testRateApartment_WithModerateThreshold() throws EntityNotFoundException {
		Apartment apartment = new Apartment(80.0, BigDecimal.valueOf(7000.0));
	    Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
	    int result = service.rateApartment(1);
	    assertEquals(1, result);
	}
	
	@Test
    void testRateApartment_AboveModerateThreshold_ReturnsTwo()throws EntityNotFoundException  {
        Apartment apartment = new Apartment(120.0, BigDecimal.valueOf(10000.0));
        Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
        int result = service.rateApartment(1);
        assertEquals(2, result);
    }
	
	@Test
    void should_ReturnException_When_NotFoundApartment(){
        Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);
        Executable executable = () -> service.rateApartment(1);
        EntityNotFoundException e=assertThrows(EntityNotFoundException.class, executable);
        assertEquals("Apartment with id 1 not found", e.getMessage());
    }
	
	@Test
    void testUpdateArea_AreaGreaterThan1000() {
		int apartmentId = 1;
        double area = 1200.0;
        Apartment apartment = new Apartment(apartmentId, 80.0, BigDecimal.valueOf(6000.0));
        Mockito.when(dao.findApartment(apartmentId)).thenReturn(apartment);
		Executable executable = () -> service.updateArea(apartmentId, area);
		BadRequestException e=assertThrows(BadRequestException.class, executable);
        assertEquals("Cannot update area to a value greater than 1000", e.getMessage());
    }
	
	
	@Test
    void testUpdateArea_ReturnsRate() throws BadRequestException, EntityNotFoundException  {
        double area = 72.0;
        int apartmentId=1;
        
        Apartment apartment = new Apartment(apartmentId,80.0, BigDecimal.valueOf(400000.0));
        Apartment updatedApartment = new Apartment(apartmentId, area, BigDecimal.valueOf(6000.0));
        Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
        Mockito.when(dao.updateApartment(Mockito.any())).thenReturn(updatedApartment);
        int result=service.updateArea(apartmentId, area);

        assertEquals(2, result );
    } 
	
}
