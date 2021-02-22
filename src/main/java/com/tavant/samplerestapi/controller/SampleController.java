package com.tavant.samplerestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.samplerestapi.exception.PasswordsUnmatchedException;
import com.tavant.samplerestapi.exception.WrongUserCredentialException;
import com.tavant.samplerestapi.models.Registerusers;
import com.tavant.samplerestapi.payloads.ApiResponse;
import com.tavant.samplerestapi.payloads.SignUpRequest;
import com.tavant.samplerestapi.repository.SampleRepository;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class SampleController {
	@Autowired
	SampleRepository res ; 
	
	@Autowired
    PasswordEncoder passwordEncoder;

 

    @Autowired
    private Environment env;
    
    @GetMapping("/")
	public Object home() {
		//return "hello from auth app" + env.getProperty("server.port");
		return this.res.findAll();
	}
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (res.existsByName(signUpRequest.getName())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

 

        if (res.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
        }

 

        Registerusers reg= new Registerusers();
        reg.setName(signUpRequest.getName());
       reg.setEmail(signUpRequest.getEmail());
       reg.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
//       reg.setRepassword(passwordEncoder.encode(signUpRequest.getRepassword()));


 


       res.save(reg);

 

        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
    }

//    @GetMapping("/login/{mail}")
//	public  ResponseEntity<?> loginUser(@Valid @RequestBody SignUpRequest signUpRequest,@PathVariable("mail") String mail) {
//
//        if (!(res.existsByEmail(signUpRequest.getEmail()))) {
//            return new ResponseEntity(new ApiResponse(false, "No such user exists"), HttpStatus.BAD_REQUEST);
//        }
//        
//        Registerusers reg= new Registerusers();
//        reg.setName(signUpRequest.getName());
//       reg.setEmail(signUpRequest.getEmail());
//        res.save(reg);
//        
//        return this.res.find
//		
//	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
				
//	@PostMapping
//	public Registerusers addRegister(@RequestBody @Valid Registerusers register) throws PasswordsUnmatchedException  {
//		
//		
//		if (!(register.getPassword().equals(register.getRepassword()))) {
//			throw new PasswordsUnmatchedException("password and repasswords should be same.");
//		}
//		else {
//			return res.save(register);
//		}
//		
//	}
//	@GetMapping("/all")
//	public List<Registerusers> getAllUsers() {
//		List list = this.res.findAll();
//        return res.saveAll(list);
//	}
//	
//	@PostMapping("/login")
//	public Registerusers loginUser(@RequestBody @Valid Registerusers register) throws WrongUserCredentialException {
//		String mail = register.getEmail();
//		String password = register.getPassword();
//		Registerusers reg = null;
//		if (mail!=null&&password!=null) {
//			reg=res.findByEmailAndPassword(mail, password);
//		}
//		if(reg==null) {
//			throw new WrongUserCredentialException("Mail and passwords are invalid.");
//		}
//		return reg;
//		
//	}
	
	
}


	    
	  
