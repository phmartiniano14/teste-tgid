package com.br.demo.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.demo.model.SaldoModel;
import com.br.demo.model.UserModel;
import com.br.demo.repository.UserRepository;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

@Service
public class UserService {

	@Autowired
//	UserRepository usuarioRepository = new UserRepository();
	
	Scanner sc = new Scanner(System.in);
	
	
	public UserModel tipoConta(UserModel userModel) {
		// TODO Auto-generated method stub 
	
		try {
			if(userModel.getCnpjCpf().length() == 11) {
				
			String cpf = userModel.getCnpjCpf();
				
				if(this.validaCPF(cpf)) {
					
					userModel.setCpf(cpf);
					userModel.setTipoConta(true);
					
				}
	
	 		}
			
			
			else if(userModel.getCnpjCpf().length() == 14) {
			
				String cnpj = userModel.getCnpjCpf();
				
				if(this.validaCPF(cnpj)) {
					
					userModel.setCpf(cnpj);
					userModel.setTipoConta(false);
					
				}
			}
			
			else if(userModel.getCnpjCpf().length() != 14  || userModel.getCnpjCpf().length() == 11 ) {
				return  Exception(HttpStatus.NOT_FOUND, "numero de documento invalido");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userModel;


	}
	
	
	public SaldoModel saque(UserModel userModel) {
	
		try {
			
	
		
		SaldoModel saldo = new  SaldoModel();
		
		System.out.println("qual valor que deseja sacar ?");
		
		double saldonovo = sc.nextDouble();
		
		if(saldonovo <= saldo.getSaldo()-(saldo.getSaldo()*0.01)) {
		 
			System.out.println("saque aprovado");
			
			return saldo;
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;  
		
	}

		

	

public SaldoModel depositar(UserModel userModel) {
	
	try {
			
		SaldoModel saldo = new  SaldoModel();
		
		//listar empresas 
		
		System.out.println("em qual empresa deseja depositar ?");
	
		String empresa = sc.next();
		
		System.out.println("qual valor deseja depositar ");
		
		double acrecentrar = sc.nextDouble();
		
		
		acrecentrar = acrecentrar - (acrecentrar*0.01);
		
		saldo.setSaldo(acrecentrar);
		

		System.out.println("deposito feito com sucesso ");		
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;  

	
}
	
	
	public boolean validaCPF(String cpf){ 
		 CPFValidator cpfValidator = new CPFValidator(); 
		    try{ cpfValidator.assertValid(cpf); 
		    return true; 
		    }catch(Exception e){ 
		        e.printStackTrace(); 
		        return false; 
		    } 
	}
	
	public boolean validaCNPJ(String cpf){ 
		 CNPJValidator cnpjValidator = new CNPJValidator(); 
		    try{ cnpjValidator.assertValid(cpf); 
		    return true; 
		    }catch(Exception e){ 
		        e.printStackTrace(); 
		        return false; 
		    } 
	}
	
	
	private UserModel Exception(HttpStatus notFound, String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
