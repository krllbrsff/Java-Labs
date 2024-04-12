package org.itmo;

import org.itmo.DTO.CatDTO;
import org.itmo.DTO.OwnerDTO;
import org.itmo.dao.ICatDao;
import org.itmo.dao.IOwnerDao;
import org.itmo.entities.Cat;
import org.itmo.entities.Owner;
import org.itmo.service.CatService;
import org.itmo.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Tests {
    private ICatDao catDao;
    private IOwnerDao ownerDao;
    private CatService catService;
    private OwnerService ownerService;

    @BeforeEach
    public void setup() {
        catDao = Mockito.mock(ICatDao.class);
        ownerDao = Mockito.mock(IOwnerDao.class);
        catService = new CatService(catDao);
        ownerService = new OwnerService(ownerDao);
    }

    @Test
    public void testGetAllCats() {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        when(catDao.findAll()).thenReturn(Arrays.asList(cat1, cat2));

        List<CatDTO> cats = catService.getAllCats();

        assertEquals(2, cats.size());
        verify(catDao, times(1)).findAll();
    }

    @Test
    public void testGetAllOwners() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        when(ownerDao.findAll()).thenReturn(Arrays.asList(owner1, owner2));

        List<OwnerDTO> owners = ownerService.getAllOwners();

        assertEquals(2, owners.size());
        verify(ownerDao, times(1)).findAll();
    }

    @Test
    public void testAddCat() {
        CatDTO catDto = new CatDTO(null, null, null, null, null, null, null);
        catService.addCat(catDto);
        verify(catDao, times(1)).save(any(Cat.class));
    }

    @Test
    public void testDeleteCat() {
        Cat cat = new Cat();
        when(catDao.findById(anyLong())).thenReturn(cat);
        catService.deleteCat(1L);
        verify(catDao, times(1)).delete(cat);
    }

    @Test
    public void testAddOwner() {
        OwnerDTO ownerDto = new OwnerDTO(null, null, null, null);
        ownerService.addOwner(ownerDto);
        verify(ownerDao, times(1)).save(any(Owner.class));
    }

    @Test
    public void testDeleteOwner() {
        Owner owner = new Owner();
        when(ownerDao.findById(anyLong())).thenReturn(owner);
        ownerService.deleteOwner(1L);
        verify(ownerDao, times(1)).delete(owner);
    }

    @Test
    public void testAddFriend() {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        when(catDao.findById(1L)).thenReturn(cat1);
        when(catDao.findById(2L)).thenReturn(cat2);
        catService.addFriend(1L, 2L);
        assertTrue(cat1.getFriends().contains(cat2));
        verify(catDao, times(1)).update(cat1);
    }

    @Test
    public void testAddCatToOwner() {
        Owner owner = new Owner();
        CatDTO catDto = new CatDTO(null, null, null, null, null, null, null);
        when(ownerDao.findById(anyLong())).thenReturn(owner);
        ownerService.addCat(1L, catDto);
        assertTrue(owner.getCats().contains(catDto.toEntity()));
        verify(ownerDao, times(1)).update(owner);
    }

    @Test
    public void testDeleteCatFromOwner() {
        Owner owner = new Owner();
        CatDTO catDto = new CatDTO(null, null, null, null, null, null, null);
        owner.getCats().add(catDto.toEntity());
        when(ownerDao.findById(anyLong())).thenReturn(owner);
        ownerService.deleteCat(1L, catDto);
        assertFalse(owner.getCats().contains(catDto.toEntity()));
        verify(ownerDao, times(1)).update(owner);
    }
}