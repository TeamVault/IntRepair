/**
 * generated by Xtext
 */
package org.xtext.example.mydsl.ui.contentassist;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;


import javax.security.auth.Subject;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.xtext.example.mydsl.myDsl.FunctionAnnotation;
import org.xtext.example.mydsl.myDsl.SecurityType;
import org.xtext.example.mydsl.ui.contentassist.AbstractMyDslProposalProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class MyDslProposalProvider extends AbstractMyDslProposalProvider {
	
	//top
    // public static ArrayList<String> headerList = new ArrayList<String>(Arrays.asList("/*@", "//@ @function","//@ @parameter"));
  
    //multiline annotation
    public static ArrayList<String> multilineList = new ArrayList<String>(Arrays.asList(
    		"/*@", 
    		"@*/", 
    		"@function", 
    		"@parameter",
    		"@preStep",
    		"@postStep",
    		"declasification",
    		"confidential",
    		"sensitive",
    		"sanitisation",
    		"sink",
    		"source",
    		"trust_boundary",
    		"L",
    		"H"
    		));
    public static ArrayList<String> functionAnnotationList = new ArrayList<String>(Arrays.asList(
    		"@function", 
    		"@parameter",
    		"declasification",
    		"confidential",
    		"sensitive",
    		"sanitisation",
    		"sink","source",
    		"trust_boundary"));
 
    //single line annotation
    public static ArrayList<String> singleLineAnnotationList = new ArrayList<String>(Arrays.asList(
    		"//@ @function ", 
    		"//@ @parameter",
    		"//@ @preStep",
    		"//@ @postStep",
    		"@variable"
    		));
    
    //common betwen single and multiline annotations
    public static ArrayList<String> functionTypeList = new ArrayList<String>(Arrays.asList(
    		"declasification",
    		"sanitisation",
    		"sink",
    		"source",
    		"trust_boundary"));
    public static ArrayList<String> securityTypeList = new ArrayList<String>(Arrays.asList(
    		"confidential",
    		"sensitive"));
  

//	public void complete_HeaderModel(EObject model, RuleCall ruleCall,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		// call implementation of superclass
//		super.complete_HeaderModel(model, ruleCall, context, acceptor);
//
//		// compute the plain proposal
//		String proposal1 = "//Security annotations: ";
//		acceptor.accept(createCompletionProposal(proposal1, context));
//		for(int i=0;i < headerList.size();i++){
//			String value=headerList.get(i);
//			acceptor.accept(createCompletionProposal(value, context));		
//		}
//		
//	}
	public void complete_MultilineAnnotation(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// call implementation of superclass
		super.complete_MultilineAnnotation(model, ruleCall, context, acceptor);
		for(int i=0;i < multilineList.size();i++){
			String value=multilineList.get(i);
			acceptor.accept(createCompletionProposal(value, context));		
		}
	}
	public void complete_FunctionAnnotation(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	
		// call implementation of superclass
		super.complete_FunctionAnnotation(model, ruleCall, context, acceptor);

		// compute the plain proposal

		for(int i=0;i < functionAnnotationList.size();i++){
			String value=functionAnnotationList.get(i);
			acceptor.accept(createCompletionProposal(value, context));		
		}
	}
	
	public void complete_FunctionType(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// call implementation of superclass
		super.complete_FunctionType(model, ruleCall, context, acceptor);
		for(int i=0;i < functionTypeList.size();i++){
			String value=functionTypeList.get(i);
			acceptor.accept(createCompletionProposal(value, context));		
		}
	}
	
	public void complete_SecurityType(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// subclasses may override
		super.complete_SecurityType(model, ruleCall, context, acceptor);

		for(int i=0;i < securityTypeList.size();i++){
			String value=securityTypeList.get(i);
			acceptor.accept(createCompletionProposal(value, context));

			 //super.completeKeyword(keyword, contentAssistContext, acceptor);			
		}
	}


	public void complete_SingleLineAnnotation(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// subclasses may override
		super.complete_SingleLineAnnotation(model, ruleCall, context, acceptor);
		for(int i=0;i < singleLineAnnotationList.size();i++){
			String value=singleLineAnnotationList.get(i);
			acceptor.accept(createCompletionProposal(value, context));		
		}
	
	}
	
	
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor){
        
		if( !keyword.getValue().contains("???") ) {
		     // System.out.println("Security keywords: "+keyword.getValue());
            return;
		  }else {
	    	  //populate the list
	          super.completeKeyword(keyword, contentAssistContext, acceptor);
	    	 // System.out.println("Security annotaion: "+keyword.getValue());
	      }    
  }
		 
	
	
}