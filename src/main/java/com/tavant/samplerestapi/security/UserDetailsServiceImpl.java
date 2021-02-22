package com.tavant.samplerestapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tavant.samplerestapi.models.Registerusers;
import com.tavant.samplerestapi.repository.SampleRepository;

@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	SampleRepository registerRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Registerusers register = registerRepository.findByName(name).orElseThrow
				(()->new UsernameNotFoundException("User not found with username"+name)
				);
				
		return RegisterPrincipal.create(register);
	}

}



//@Override
//@Transactional
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    // Let people login with either username or email
//    Authentication authentication = authenticationRepository.findByUsername(username)
//            .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));
//
//
//
//    return AuthenticationPrincipal.create(authentication);
//}
//
//
//
//// This method is used by JWTAuthenticationFilter
//@Transactional
//public UserDetails loadUserById(Long id) {
//    Authentication authentication = authenticationRepository.findById(id)
//            .orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
//
//
//
//    return AuthenticationPrincipal.create(authentication);
//}
//}