package com.boot.brightideas.service;

import java.util.List;
import java.util.Optional;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.worscipe.bright.users.model.UserImpl;
import com.worscipe.bright.users.repository.UserRepository;
import com.worscipe.bright.users.service.UserServiceImpl;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.PassStrengthType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	

	//Setup
	
	
	@Mock
	private UserRepository mockUserRepository;
	
	private List<UserImpl> userImpls;
	private UserImpl userImpl; 
	private Optional<UserImpl> optional; 
	private Optional<UserImpl> emptyOptional;
	
	private Long INVALID_ID = -1L;
	private String INVALID_EMAIL = "null@email.invalid";
	
	private MockNeat mockNeat; 
	
	private List<UserImpl> initMockUsers(Integer number) {
		 
		 	mockNeat = MockNeat.threadLocal();
		 	
			// we setup the data to be returned
			List<UserImpl> mockUsers = mockNeat.reflect(UserImpl.class)
					 // We need predictable id values, see for(long i ... loop below) .field("id", mockNeat.longSeq())
						.field("email", mockNeat.emails())
						.field("password", mockNeat.passwords().types(PassStrengthType.WEAK, PassStrengthType.MEDIUM))
						.field("firstName", mockNeat.names().first())
						.field("lastName", mockNeat.names().last())
						.list(number)
						.val();
			for(long i = 0L; i < number; i++) {
			mockUsers.get((int) i).setId((Long)i);
			}
			return mockUsers; 
		}
	
	@InjectMocks
	private UserServiceImpl userServiceUnderTest;
	
	
	@BeforeSuite
	public void initMocks() {
		//we give userService the mockRepository that it needs to perform the test without a live database.
			MockitoAnnotations.initMocks(this);
			emptyOptional = Optional.empty();
	}
	
	/*  Alternative setup syntax to understand the concept of what the annotations above are doing.
	 *  	UserServiceImpl userServiceUnderTest = new UserServiceImpl();
	 *		UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
	 *		userServiceUnderTest.setUserRepository(mockUserRepository);
	 */

	
	@BeforeMethod
	private void initMockData() {
		/** Internally uses the ThreadLocalRandom implementation */
		userImpls = initMockUsers(2); 
		userImpl = userImpls.get(0);
		optional = Optional.of(userImpl);
	}
	
	
	@Test(priority=1)
	public void shouldGetUsers() {
		
	       // with the methed stubbed by the mock repository, so we know that we will get a result when we attempt to use the findAll() method. 
		Mockito.when(mockUserRepository.findAll())
			   .thenReturn(userImpls);
		
		// Excecution
		List<UserImpl> result = userServiceUnderTest.findAllUsers();
		
		// Verification
			// pass in the mock Reference and then state the method we want to be verified. 
		Mockito.verify(mockUserRepository).findAll();
			// verify the data
		Assert.assertEquals(result, userImpls, "List<User> returned from service DID NOT equal List<User> mocked");
	}
	
	@Test(priority=2)
	public void shouldExistById() {
		
		Mockito.when(mockUserRepository.findById(userImpl.getId()))
				.thenReturn(optional);
		
		Boolean result = userServiceUnderTest.existsById(userImpl.getId());
		
		Mockito.verify(mockUserRepository).findById(userImpl.getId());
		
		Assert.assertTrue(result, "existsById(uid) should have returned True, because known user with id:["+userImpl.getId()+"] mocked") ; 	
	}
	
	@Test(priority=3)
	public void shouldNotExistById() {
		Mockito.when(mockUserRepository.findById(INVALID_ID))
				.thenReturn(emptyOptional);
		
		Boolean result = userServiceUnderTest.existsById(INVALID_ID);
		
		Mockito.verify(mockUserRepository).findById(INVALID_ID);
		
		Assert.assertFalse(result, "The service is telling us a user with an invalid id:"+ INVALID_ID +" exists with a 'true' response");
				
	}
	
	
	@Test(priority=4)
	public void shouldExistByEmail() {
		Mockito.when(mockUserRepository.findByEmail(userImpl.getEmail()))
				.thenReturn(optional);
		
		Boolean result = userServiceUnderTest.existsByEmail(userImpl.getEmail());
		
		Mockito.verify(mockUserRepository).findByEmail(userImpl.getEmail());
		
		
		Assert.assertTrue(result, "existByEmail("+userImpl.getEmail()+") of a known user is returning false (implying user wasn't found)");
		
	}
	
	
	@Test(priority=5)
	void shouldNotExistByEmail() {
		Mockito.when(mockUserRepository.findByEmail(INVALID_EMAIL))
			.thenReturn(emptyOptional);
		
		Boolean result = userServiceUnderTest.existsByEmail(INVALID_EMAIL);
		
		Mockito.verify(mockUserRepository).findByEmail(INVALID_EMAIL);
		
		Assert.assertFalse(result, "existsByEmail("+INVALID_EMAIL+") is returning True (implying an email that should not exist does)");
		
		

	}
	
	@Test(priority=6)
	public void shouldGetUserById() {
		Mockito.when(mockUserRepository.findById(userImpl.getId()))
			.thenReturn(optional);
		
		UserImpl result = userServiceUnderTest.findById(userImpl.getId()); 
		
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(userImpl.getId());
		Assert.assertEquals(result, userImpl, "Users should be the same but are not");
	}
	
	@Test(priority=7)
	public void shouldGetNullUserById() {
		Mockito.when(mockUserRepository.findById(INVALID_ID))
			.thenReturn(emptyOptional);
		
		UserImpl result = userServiceUnderTest.findById(INVALID_ID); 
		
		// verify that Repo was NOT called,  Mockito.times(0) means no method invocations
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(INVALID_ID);
		Assert.assertNull(result, "The findById(-1L), shouldn't be returning a value");
		
	}
	
	
	@Test(priority=8)
	public void shouldGetUserByEmail() {
		Mockito.when(mockUserRepository.findByEmail(userImpl.getEmail()))
			.thenReturn(optional);
		
		UserImpl result = userServiceUnderTest.findByEmail(userImpl.getEmail());
		
		Mockito.verify(mockUserRepository).findByEmail(userImpl.getEmail());
		
		Assert.assertEquals(result, userImpl, "the findByEmail() method should return the known user we mocked");
		
	}
	
	@Test(priority=9)
	public void shouldGetNullUserByEmail() {
		Mockito.when(mockUserRepository.findByEmail(INVALID_EMAIL))
			.thenReturn(emptyOptional);
			
	    UserImpl result = userServiceUnderTest.findByEmail(INVALID_EMAIL);
	    
	    Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findByEmail(INVALID_EMAIL);
	    
	    Assert.assertNull(result, "the findbyEmail("+ INVALID_EMAIL +") method should return null, but returns:" + result);
	}
	
	
	@Test(priority=10)
	public void shouldSaveUser() {
		 
		UserImpl newUser = initMockUsers(1).get(0); 
		
		Mockito.when(mockUserRepository.save(newUser))
			.thenReturn(newUser);
		
		UserImpl result = userServiceUnderTest.saveUser(newUser); 
		
		Mockito.verify(mockUserRepository).save(newUser);
		
		Assert.assertEquals(result, newUser, "new User retuned from saveUser: " + result +", should match the newUser we mocked:" + newUser);
		
		
	}
	

	@Test(priority=11)
	public void shouldUpdateUser() {
		
		UserImpl userToUpdate = userImpls.get(0); 
		Long userToUpdateId = userToUpdate.getId();
		
		UserImpl userUpdate = initMockUsers(1).get(0);
		
		//just to be sure
		userUpdate.setId(userToUpdateId);
				
		Mockito.when(mockUserRepository.save(userUpdate))
			.thenReturn(userUpdate);
		

		UserImpl result = userServiceUnderTest.saveUser(userUpdate);
		
		Mockito.verify(mockUserRepository).save(userUpdate);
		
		Assert.assertEquals(result, userUpdate, "updatedUser returned from saveUser(" + userUpdate + "), does not match mocked user returned: " + result );
		
	}
	
	@Test(priority=12)
	public void shouldDeleteUserById() {
		
		Long userToDeleteId = userImpls.get(0).getId();
		
		Answer<Boolean> answer = new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) {
		          return (Boolean) true;
		     	}
		};
		
		Mockito.when(mockUserRepository.findById(userImpl.getId())).thenReturn(optional);
		Mockito.doAnswer(answer).when(mockUserRepository).deleteById(userToDeleteId);
		
		Boolean result = userServiceUnderTest.deleteUserById(userToDeleteId); 
		
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).deleteById(userToDeleteId);
		
		Assert.assertTrue(result, "We gave a vaild id(user: "+ userToDeleteId +") of a user to delete, but service returned false (implying a delete failure)" );
	}
	
	@Test(priority=13)
	public void shouldNotDeleteUserByInvalidId() {
			
		Answer<Boolean> answer = new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) {
		          return (Boolean) false;
		     	}
		};
		
		Mockito.when(mockUserRepository.findById(INVALID_ID)).thenReturn(emptyOptional);
		Mockito.doAnswer(answer).when(mockUserRepository).deleteById(INVALID_ID);
		
		
		Boolean result = userServiceUnderTest.deleteUserById(INVALID_ID); 
		
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(INVALID_ID);
		
		Assert.assertFalse(result, "We gave deleteUserById a non-existant id but service returned true (implying a successful delete)");
		
	}
	
	@Test(priority=14)
	public void shouldDeleteUser() {
				
		Answer<Boolean> answer = new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) {
		          return (Boolean) true;
		     	}
		};
		
		Mockito.when(mockUserRepository.findById(userImpl.getId())).thenReturn(optional);
		Mockito.doAnswer(answer).when(mockUserRepository).delete(userImpl);
		
		
		Boolean result = userServiceUnderTest.deleteUser(userImpl);
	
	
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).delete(userImpl);
	
		Assert.assertTrue(result, "Failed to delete: " + userImpl);
	}
	
	@Test(priority=15)
	public void shouldNotDeleteUser() {
		
		UserImpl invalidUser = initMockUsers(2).get(0); 
		
		Answer<Boolean> answer = new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) {
		          return (Boolean) false;
		     	}
		};
		
		Mockito.when(mockUserRepository.findById(invalidUser.getId())).thenReturn(emptyOptional);
		Mockito.doAnswer(answer).when(mockUserRepository).delete(invalidUser);
		
		Boolean existsResult = userServiceUnderTest.existsById(invalidUser.getId());
		Boolean result = userServiceUnderTest.deleteUser(invalidUser);
		
		Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(invalidUser.getId());
		
		Assert.assertFalse(existsResult, "User shouldn't exist but does");
		Assert.assertFalse(result, "There should have been no user deleted returning false");

	}
}
