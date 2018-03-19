package smtcodan;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTArrayDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTArrayModifier;
import org.eclipse.cdt.core.dom.ast.IASTArraySubscriptExpression;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTCaseStatement;
import org.eclipse.cdt.core.dom.ast.IASTCastExpression;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTElaboratedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTEnumerationSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTEqualsInitializer;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFieldReference;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.cdt.core.dom.ast.IASTInitializerList;
import org.eclipse.cdt.core.dom.ast.IASTLiteralExpression;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNamedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;
import org.eclipse.cdt.core.dom.ast.IASTReturnStatement;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;
import org.eclipse.cdt.core.dom.ast.IASTTypeIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTUnaryExpression;
import org.eclipse.cdt.core.dom.ast.IArrayType;
import org.eclipse.cdt.core.dom.ast.IBasicType;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.ICompositeType;
import org.eclipse.cdt.core.dom.ast.IEnumerator;
import org.eclipse.cdt.core.dom.ast.IField;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.cdt.core.dom.ast.IFunctionType;
import org.eclipse.cdt.core.dom.ast.IPointerType;
import org.eclipse.cdt.core.dom.ast.IType;
import org.eclipse.cdt.core.dom.ast.ITypedef;
import org.eclipse.cdt.core.dom.ast.IValue;
import org.eclipse.cdt.core.dom.ast.IVariable;
import org.eclipse.cdt.core.dom.ast.c.ICASTDesignator;
import org.eclipse.cdt.core.dom.ast.c.ICASTTypedefNameSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCapture;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTTemplateParameter;
import org.eclipse.cdt.core.index.IIndexBinding;

import smtcodan.environment.Mgetenv;
import smtcodan.interpreter.IFunctionCallCollector;
import smtcodan.interpreter.Interpreter;
import smtcodan.parser.AnnotationExecution;
import smtcodan.parser.FunctionComment;
import smtcodan.parser.ParameterComment;
import smtcodan.symvars.ISymObject;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymArraySSA;
import smtcodan.symvars.SymBoolOrig;
import smtcodan.symvars.SymBoolSSA;
import smtcodan.symvars.SymComposite;
import smtcodan.symvars.SymFctPointer;
import smtcodan.symvars.SymFctPointerSSA;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarOrig;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;
import smtcodan.translator.AttrDeclType;
import smtcodan.translator.AttrFunction;
import smtcodan.translator.AttrName;
import smtcodan.translator.AttrPointer;
import smtcodan.translator.AttrSymComposite;
import smtcodan.translator.AttrSymType;
import smtcodan.translator.AttrSymVar;
import smtcodan.translator.ITrxAttribute;
import smtcodan.translator.OpTranslator;
import smtcodan.translator.SymTypeBuilder;
import smtcodan.translator.TrxAttributeList;

public class LocalizerVisitor extends ASTVisitor implements
		IFunctionCallCollector {

	// FIXME: cleanup

	// TODO: use type promotion tables for operators
	// TODO: use only SymVarSSAs for implicit and env variables, not SymVarOrigs
	// (INames maybe not necessary, check SymFctCalls)
	// TODO: eliminate implicit variables with symbolic constant propagation
	// (saves space)
	// TODO: semantic actions as single methods
	// TODO: proper nullpointer handling

	Interpreter ps;
	public static TrxAttributeList attrList;
	public static ArrayList<IASTName> fcnames;

	public static ArrayList<String> bindings = new ArrayList<String>();
	public boolean status = false;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalizerVisitor(Interpreter ps) {
		// TODO Auto-generated constructor stub

		this.ps = ps;
		attrList = new TrxAttributeList();
		fcnames = new ArrayList<IASTName>();

		shouldVisitExpressions = true;
		shouldVisitDeclarations = true;
		shouldVisitNames = true;
		shouldVisitDeclarators = true;
		shouldVisitInitializers = true;
		shouldVisitDeclSpecifiers = true;
		shouldVisitStatements = true;
		shouldVisitArrayModifiers = true;
		shouldVisitAttributes = true;
		shouldVisitBaseSpecifiers = true;
		shouldVisitCaptures = true;
		shouldVisitDesignators = true;
		shouldVisitEnumerators = true;
		shouldVisitImplicitNames = true;
		shouldVisitParameterDeclarations = true;
		shouldVisitPointerOperators = true;
		shouldVisitTypeIds = true;

	}

	public TrxAttributeList getAttrList() {
		return attrList;
	}

	public int visit(IASTStatement sm) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTExpression expr) {
		// TODO: move function call return here?

		IType etype = expr.getExpressionType();
		if (expr instanceof IASTCastExpression) {
			// malloc model
			// FIXME: refine and move to Environment after op_sizeof is properly
			// modelled ?
			IASTCastExpression cexpr = (IASTCastExpression) expr;
			IASTExpression operand = cexpr.getOperand();
			if (operand instanceof IASTFunctionCallExpression) {

				IASTExpression nameex = ((IASTFunctionCallExpression) operand)
						.getFunctionNameExpression();
				if (nameex instanceof IASTIdExpression) {
					IASTName fname = ((IASTIdExpression) nameex).getName();
					if (fname.toString().compareTo("malloc") == 0) {
						// malloc model:
						// instanciate symbolic cast result
						if (etype instanceof ITypedef) {
							IType type = ((ITypedef) etype).getType();
							// TODO: correct local/global scope:
							// declare global (heap), used e.g. to pass pthread
							// start arguments...
							ISymObject so = SymTypeBuilder.getInstance()
									.buildDeclareInit(ps, null, type, null,
											true);
							AttrSymVar asv = new AttrSymVar((SymVarSSA) so);
							attrList.add(expr, asv);
						}
						return PROCESS_SKIP;

					}
				}
			}
		}
		return PROCESS_CONTINUE;
	}

	public int visit(IASTDeclaration decl) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTDeclSpecifier dspec) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTDeclarator decl) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTArrayModifier am) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTPointerOperator ptrop) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTInitializer ini) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTEnumerationSpecifier.IASTEnumerator enumerator) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTParameterDeclaration parameterDeclaration) {
		return PROCESS_CONTINUE;
	}

	public int visit(IASTTypeId typeId) {
		return PROCESS_CONTINUE;
	}

	public int visit(ICASTDesignator designator) {
		return PROCESS_CONTINUE;
	}

	public int visit(ICPPASTCapture capture) {
		return PROCESS_CONTINUE;
	}

	public int visit(
			ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier baseSpecifier) {
		return PROCESS_CONTINUE;
	}

	public int visit(ICPPASTNamespaceDefinition namespaceDefinition) {
		return PROCESS_CONTINUE;
	}

	public int visit(ICPPASTTemplateParameter templateParameter) {
		return PROCESS_CONTINUE;
	}

	public int leave(IASTStatement sm) {
		if (sm instanceof IASTReturnStatement) {
			IASTExpression rve = ((IASTReturnStatement) sm).getReturnValue();
			AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(rve,
					"symvar");
			SymFctSignature fsign = ps.peekSymFctSign();
			if (fsign != null) {
				if (fsign.hasRType()) {
					// declare implicit SymVar
					SymVarSSA ssa = asymvar.getSymVar();
					SymFunctionReturn sfr = new SymFunctionReturn(ssa);
					ps.setNextRVal(sfr);
				} else {
					// else void fct without return statement, set dummy return
					// value
					ps.setNextRVal(new SymFunctionReturn());
				}
			} else if (asymvar != null) {
				// leaving main... maybe cleaner with SymFctSignature for
				// main()?
				ps.setNextRVal(new SymFunctionReturn(asymvar.getSymVar()));
			} else {
				// else void fct without return statement, set dummy return
				// value
				ps.setNextRVal(new SymFunctionReturn());
			}
		} else if (sm instanceof IASTCaseStatement) {
			IASTExpression cexpr = ((IASTCaseStatement) sm).getExpression();
			AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(cexpr,
					"symvar");
			attrList.add(sm, asymvar);
		}
		return PROCESS_CONTINUE;
	}

	// declaration-specifiers attribute-seqopt init-declarator-listopt;
	// notifyLimitChecker ProgramPath

	public int leave(IASTDeclaration decl) {

		IASTSimpleDeclaration sdecl = (IASTSimpleDeclaration) decl;
		IASTDeclSpecifier dspec = sdecl.getDeclSpecifier();
		AttrDeclType declType = (AttrDeclType) attrList.getAttribute(dspec,
				"declType");
		IASTDeclarator[] decls = sdecl.getDeclarators();
		for (IASTDeclarator declarator : decls) {
			AttrName aname = (AttrName) attrList.getAttribute(declarator,
					"name");
			IName iName = aname.getIName();
			IASTInitializer ini = declarator.getInitializer();
			SymVarSSA ini_ssa = null;
			AttrSymVar attrIni = null;
			if (ini != null) {

				attrIni = (AttrSymVar) attrList.getAttribute(ini, "symvar");
				ini_ssa = attrIni.getSymVar();

				if (ini instanceof IASTEqualsInitializer) {
					if (ini_ssa != null) {
						String str = ini.getRawSignature().toString();

						// the checker works also without these checks
						// if these checks are removed than some false positives
						// will be reported in cwe-366
						if (!ini.getRawSignature().toString().equals("= \"\"")
								&& !ini.getRawSignature().toString()
										.equals("= NULL")
								&& (ini.getRawSignature().toString()
										.contains(" + ") || ini
										.getRawSignature().toString()
										.contains(" * "))

						) {
							ps.notifyLimitChecker(ini_ssa, ini);
						}
					}
				}
			}
			eSymType symtype = null;
			if (dspec instanceof IASTElaboratedTypeSpecifier) {
				IASTNode strName = dspec.getOriginalNode();
				strName = dspec.getParent();
				IASTNode strName1 = ((IASTElaboratedTypeSpecifier) dspec)
						.getName();

				IASTElaboratedTypeSpecifier ets = (IASTElaboratedTypeSpecifier) dspec;
				int targetKind = ets.getKind();

				IASTName name = ets.getName();
				ICompositeType binding = (ICompositeType) name.resolveBinding();
				ICompositeType type = binding;
				switch (targetKind) {
				case IASTElaboratedTypeSpecifier.k_struct: {
					if (type instanceof ICompositeType) {
						symtype = eSymType.SymComposite;
						AttrSymComposite asymcomposite = (AttrSymComposite) attrList
								.getAttribute(strName1, "symcomposite");

						SymComposite sc = asymcomposite.getSymComposite();
						sc.setName(iName);
						ps.declareLocal(sc);
						System.out.println();

					}
					break;
				}
				}
			} else if (dspec instanceof IASTNamedTypeSpecifier) {
				IASTNamedTypeSpecifier ntspec = (IASTNamedTypeSpecifier) dspec;
				IASTName typedefName = ntspec.getName();
				ITypedef binding = (ITypedef) typedefName.getBinding();
				IType type = binding.getType();
				if (type instanceof ICompositeType) {
					symtype = eSymType.SymComposite;
					AttrSymComposite asymcomposite = (AttrSymComposite) attrList
							.getAttribute(dspec, "symcomposite");
					SymComposite sc = asymcomposite.getSymComposite();
					sc.setName(iName);
					ps.declareLocal(sc.getSymType(), iName);
				} else if (type instanceof IPointerType) {
					symtype = eSymType.SymPointer;
					SymPointerSSA ssa = (SymPointerSSA) ps.declareLocal(
							eSymType.SymPointer, iName);
					ps.declareLocal(symtype, iName);
					attrList.add(decl, attrIni);
					if (ini_ssa != null) {
						SymPointerSSA ini_sp = (SymPointerSSA) ini_ssa;
						ssa.setLevel(ini_sp.getLevel());
						ssa.setTarget(ini_sp.getTarget());
						ssa.setFormula(ini_sp.getFormula());
						if (ini_sp.getTarget() != null) {
							ssa.setTargetType(ini_sp.getTarget().getSymType());
						}
					}
				} else if (type instanceof IBasicType) {
					symtype = eSymType.SymInt;
					SymVarOrig so = null;
					switch (type.toString()) {
					case "int": {
						SymPointerSSA ssa = (SymPointerSSA) ps.declareLocal(
								eSymType.SymPointer, iName);
						if (ini_ssa != null) {
							SymArraySSA ini_sp = (SymArraySSA) ini_ssa;

							if (ini_sp != null) {
								ssa.setTarget(ini_sp.getOrig());
								ssa.setTargetType(ini_sp.getSymType());
							}
						}
						break;
					}
					case "unsigned long int": {
						ps.declareLocal(eSymType.SymInt, iName);
						break;
					}
					case "eBoolean": {
						ps.declareLocal(eSymType.SymBool, iName);
						so = new SymBoolOrig(iName);
						break;
					}
					case "long int": {
						ps.declareLocal(eSymType.SymInt, iName);
						so = new SymBoolOrig(iName);
						break;
					}
					case "eChar":
					case "eInt": {
						ps.declareLocal(eSymType.SymInt, iName);
						so = new SymIntOrig(iName);
						break;
					}

					default: {
						(new Exception(" " + type + " TODO")).printStackTrace();
					}

					}
					if (so != null) {
						AttrSymVar asymc = new AttrSymVar(so.ssaCopy());
						attrList.add(decl, asymc);
					}
					continue;
				}
			} else {
				symtype = declType.getType();
				if (declarator instanceof IASTArrayDeclarator) {
					// get size
					AttrSymVar asymvarSize = (AttrSymVar) attrList
							.getAttribute(declarator, "symvar");
					SymIntSSA size_ssa = (SymIntSSA) asymvarSize.getSymVar();
					SymArrayOrig sb = null;
					if (ps.existsLocalOrigSymVar(iName)) {
						sb = ps.getLocalOrigSymArray(iName);
					} else {
						SymIntOrig sb_size = (SymIntOrig) ps
								.resolveOrigSymVar(size_ssa.getOrigName());

						SymArraySSA sb_ssa = (SymArraySSA) ps.declareLocal(
								eSymType.SymArray, iName);
						sb = (SymArrayOrig) sb_ssa.getOrig();
						sb.setSize(sb_size);
						sb.setElemType(symtype);
						if (ini_ssa != null) {
							if (ini_ssa.getESymType() == eSymType.SymInt) {
								String formula = new String("(assert (= "
										+ sb_ssa.getSSAName() + " (store "
										+ sb_ssa.getSSAName() + " 0 "
										+ ini_ssa.getSSAName() + " )))");
								sb_ssa.setFormula(formula);
								sb_ssa.addDependency(ini_ssa);
							}
						}
					}
				} else { // no array
					SymVarOrig so = null;

					SymArrayOrig sb = null;
					AttrPointer ap = (AttrPointer) attrList.getAttribute(
							declarator, "pointer");

					if (ps.existsLocalOrigSymVar(iName)) {
						so = ps.resolveOrigSymVar(iName);
					} else {
						// declare
						if (ap != null) {
							// pointer
							SymPointerSSA sp_ssa = (SymPointerSSA) ps
									.declareLocal(eSymType.SymPointer, iName);
							// add annotations to this symbolic variable
							AnnotationExecution.labelSymbolicVariable(sp_ssa,
									iName.toString(), sdecl.getRawSignature()
											.toString());

							so = (SymPointerOrig) sp_ssa.getOrig();
							((SymPointerOrig) so).setTargetType(symtype);
							((SymPointerOrig) so).setLevel(1);
							if (ini != null) {
								if (ini_ssa instanceof SymPointerSSA) {
									SymVarOrig ini_orig_target = (SymVarOrig) ((SymPointerSSA) ini_ssa)
											.getTarget();
									sp_ssa.setTarget(ini_orig_target);
								} else if (ini_ssa instanceof SymArraySSA) {
									if (ps.existsLocalOrigSymVar(iName)) {
										sb = ps.getLocalOrigSymArray(iName);
										sp_ssa.setTarget(sb);
									} else {
										SymArraySSA sb_ssa = (SymArraySSA) ps
												.declareLocal(
														eSymType.SymArray,
														iName);
										sb = (SymArrayOrig) sb_ssa.getOrig();
										sb.setElemType(symtype);
										sp_ssa.setTarget(sb);

									}
								}

							}
						}

						else {
							// not pointer
							ps.declareLocal(symtype, iName);
							if (ini != null) {
								SymVarSSA ssa = ps.resolveOrigSymVar(iName)
										.getCurrentSSACopy();
								if (ini_ssa.getESymType() == eSymType.SymPointer) {
									// assume array access
									SymPointerSSA ini_sp = (SymPointerSSA) ini_ssa;
									SymArraySSA sa = (SymArraySSA) ini_sp
											.getTargetSSA();
									String formula = new String("(assert (= "
											+ ssa.getSSAName() + " (select "
											+ sa.getSSAName() + " "
											+ ini_sp.getSSAName() + " )))");
									ssa.setFormula(formula);
									ssa.addDependency(ini_sp);
								} else {
									String formula = new String("(assert (= "
											+ ssa.getSSAName() + " "
											+ ini_ssa.getSSAName() + " ))");
									ssa.setFormula(formula);
									ssa.addDependency(ini_ssa);
								}
							}
						}
					}

				}

			}
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTTypeId typeId) {
		IASTTypeId tid = (IASTTypeId) typeId;
		IASTDeclSpecifier dspec = tid.getDeclSpecifier();
		AttrDeclType dtype1 = (AttrDeclType) attrList.getAttribute(dspec,
				"declType");
		IASTDeclarator declarator = tid.getAbstractDeclarator();
		AttrPointer apointer1 = (AttrPointer) attrList.getAttribute(declarator,
				"pointer");
		eSymType symtype = null;
		if (dtype1 != null) {
			symtype = dtype1.getType();
		} else if (apointer1 != null) {
			symtype = eSymType.SymPointer;
		}
		AttrSymType asymtype = null;
		if (apointer1 != null) {
			SymPointerSSA spssa = (SymPointerSSA) ps.declareLocal(
					eSymType.SymPointer, null);
			SymPointerOrig spo = (SymPointerOrig) spssa.getOrig();
			spo.setLevel(1);
			spo.setTargetType(symtype);
			asymtype = new AttrSymType(spo);
			attrList.add(typeId, asymtype);
		} else if (symtype != null) {
			SymVarOrig newsymvar = null;
			switch (symtype) {
			case SymBool: {
				SymBoolSSA sbssa = (SymBoolSSA) ps.declareLocal(
						eSymType.SymBool, null);
				newsymvar = sbssa.getOrig();
				break;
			}
			case SymInt: {
				SymIntSSA sissa = (SymIntSSA) ps.declareLocal(eSymType.SymInt,
						null);
				newsymvar = sissa.getOrig();
				break;
			}
			}
			asymtype = new AttrSymType(newsymvar);
			attrList.add(typeId, asymtype);
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTDeclSpecifier dspec) {
		String str = dspec.getRawSignature();
		if (dspec instanceof IASTNamedTypeSpecifier) {
			IASTNamedTypeSpecifier nts = (IASTNamedTypeSpecifier) dspec;
			IASTName name = nts.getName();
			ITypedef binding = (ITypedef) name.resolveBinding();
			IType type = binding.getType();

			if (dspec instanceof ICASTTypedefNameSpecifier) {
				ICASTTypedefNameSpecifier nts2 = (ICASTTypedefNameSpecifier) dspec;
				IASTName name2 = nts.getName();
				ITypedef binding2 = (ITypedef) name.resolveBinding();
				IType ftype = binding2.getType();
				if (ftype instanceof ITypedef) {
					ITypedef btype = (ITypedef) ftype;
					SymVarOrig so = null;
					IName newfieldname = name;
					IBasicType elemKind = null;
					eSymType symType = null;

					if (btype.getType() instanceof IBasicType)
						elemKind = (IBasicType) btype.getType();
					else if (btype instanceof ITypedef)
						elemKind = (IBasicType) ((ITypedef) btype.getType())
								.getType();

					switch (elemKind.getKind()) {
					case eBoolean: {
						symType = eSymType.SymBool;
						break;
					}
					case eChar: {
						symType = eSymType.SymPointer;
						break;
					}
					case eInt: {
						symType = eSymType.SymInt;
						break;
					}
					default: {
						symType = eSymType.SymInt;
					}
					}
					AttrDeclType declType = new AttrDeclType(symType);
				}
			}
			if (type instanceof IBasicType) {

				IBasicType btype = (IBasicType) type;
				// TODO: initial values

				IName newfieldname = name;
				SymVarOrig so = null;
				IBasicType.Kind elemKind = ((IBasicType) btype).getKind();
				switch (elemKind) {
				case eBoolean: {
					so = new SymBoolOrig(newfieldname);
					break;
				}
				case eChar:
				case eInt: {
					so = new SymPointerOrig(newfieldname);
					break;
				}
				}

				AttrSymVar asymc = new AttrSymVar(so.ssaCopy());
				attrList.add(dspec, asymc);
			}
			if (type instanceof ICompositeType) {
				ICompositeType comptype = (ICompositeType) type;
				IField[] fields = comptype.getFields();
				SymComposite sc = (SymComposite) ps.declareLocal(
						eSymType.SymComposite, name);
				for (IField field : fields) {
					// TODO: initial values
					IType ftype = field.getType();
					String fname = field.getName();
					IName newfieldname = null;
					if (ftype instanceof IBasicType) {
						IBasicType btype = (IBasicType) ftype;
						SymVarSSA ssa = null;
						IBasicType.Kind elemKind = ((IBasicType) btype)
								.getKind();
						switch (elemKind) {
						case eBoolean: {
							ssa = (SymVarSSA) ps.declareLocal(eSymType.SymBool,
									newfieldname);
							break;
						}
						case eChar:
						case eInt: {
							ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt,
									newfieldname);
							break;
						}
						}
						SymVarOrig so = ssa.getOrig();
						sc.addField(so, fname);
					} else if (ftype instanceof IArrayType) {
						IArrayType aftype = (IArrayType) ftype;
						IValue size = aftype.getSize();
						// TODO: any depth for non-basic types
						IType elemType = aftype.getType();
						SymIntSSA soa_size_ssa = (SymIntSSA) ps.declareLocal(
								eSymType.SymInt, null);
						SymIntOrig sao_size = (SymIntOrig) soa_size_ssa
								.getOrig();
						SymArraySSA sao_ssa = (SymArraySSA) ps.declareLocal(
								eSymType.SymArray, newfieldname);
						SymArrayOrig sao = (SymArrayOrig) sao_ssa.getOrig();
						sao.setSize(sao_size);
						String ssize = new String("(assert (= "
								+ sao_size.getCurrentSSACopy().getSSAName()
								+ " " + size.toString() + " ))");
						sao_size.getCurrentSSACopy().setFormula(ssize);
						if (elemType instanceof IBasicType) {
							IBasicType.Kind elemKind = ((IBasicType) elemType)
									.getKind();
							switch (elemKind) {
							case eBoolean: {
								sao.setElemType(eSymType.SymBool);
								break;
							}
							case eChar:
								sao.setElemType(eSymType.SymArray);
								break;
							case eInt: {
								sao.setElemType(eSymType.SymInt);
								break;
							}
							}
						}
						sc.addField(sao, fname);
					} else if (ftype instanceof IPointerType) {
						// TODO: higher level pointers
						SymPointerSSA spssa = (SymPointerSSA) ps.declareLocal(
								eSymType.SymPointer, newfieldname);
						SymPointerOrig spo = (SymPointerOrig) spssa.getOrig();
						IType targetType = ((IPointerType) ftype).getType();
						if (targetType instanceof IBasicType) {
							IBasicType.Kind targetKind = ((IBasicType) targetType)
									.getKind();
							switch (targetKind) {
							case eBoolean: {
								spo.setTargetType(eSymType.SymBool);
								break;
							}
							// doubt
							case eChar: {
								spo.setTargetType(eSymType.SymInt);
								break;
							}
							case eInt: {
								spo.setTargetType(eSymType.SymInt);
								break;
							}
							}
						}

						sc.addField(spo, fname);
					}
				}
				AttrSymComposite asymc = new AttrSymComposite(sc);
				attrList.add(dspec, asymc);
			}

			else if (type instanceof IBasicType) {
				IBasicType.Kind targetKind = ((IBasicType) type).getKind();
				eSymType symType = eSymType.SymInt;
				switch (targetKind) {
				case eBoolean: {
					symType = eSymType.SymBool;
					break;
				}
				case eChar: {
					// symType = eSymType.s;
					break;
				}
				case eInt: {
					symType = eSymType.SymInt;
					break;
				}
				default: { // t_char, t_int
					symType = eSymType.SymInt;
				}
				}
				AttrDeclType declType = new AttrDeclType(symType);
				attrList.add(dspec, declType);
			}
		}

		else if (dspec instanceof IASTElaboratedTypeSpecifier) {
			IASTElaboratedTypeSpecifier ets = (IASTElaboratedTypeSpecifier) dspec;
			int targetKind = ets.getKind();
			IASTName name = ets.getName();
			ICompositeType binding = (ICompositeType) name.resolveBinding();
			ICompositeType type = binding;
			eSymType symType = eSymType.SymInt;
			switch (targetKind) {

			case IASTElaboratedTypeSpecifier.k_struct: {

				if (type instanceof ICompositeType) {
					ICompositeType compositeType = (ICompositeType) type;
					IField[] fields = compositeType.getFields();
					SymComposite sc = new SymComposite(name);

					for (IField field : fields) {
						// TODO: initial values
						IType ftype = field.getType();
						String fname = field.getName();

						SymVarOrig so = null;
						SymIntSSA so1 = null;
						SymPointerSSA so2 = null;

						// ICArrayType
						IName newfieldname = new ImpVarName();
						if (ftype instanceof IArrayType) {

							IArrayType aftype = (IArrayType) ftype;
							IValue size = aftype.getSize();
							// TODO: any depth for non-basic types
							IType elemType = aftype.getType();

							SymArraySSA sao_size = (SymArraySSA) ps
									.declareLocal(eSymType.SymArray, null);
							SymArrayOrig sao = (SymArrayOrig) sao_size
									.getOrig();

							String ssize = new String("(assert (= "
									+ sao_size.getSSAName() + " "
									+ size.toString() + " ))");

							sao_size.setFormula(ssize);
							if (elemType instanceof IBasicType) {
								IBasicType.Kind elemKind = ((IBasicType) elemType)
										.getKind();
								switch (elemKind) {
								case eBoolean: {
									sao.setElemType(eSymType.SymBool);
									break;
								}
								case eChar: {
									sao.setElemType(eSymType.SymPointer);
									so2 = (SymPointerSSA) ps.declareLocal(
											eSymType.SymPointer, null);
									sc.addField(so2.getOrig(), fname);
									break;
								}
								case eInt: {
									sao.setElemType(eSymType.SymInt);

									so1 = (SymIntSSA) ps.declareLocal(
											eSymType.SymInt, null);
									sc.addField(so1.getOrig(), fname);
									break;
								}
								}
							}

						} else if (ftype instanceof ICompositeType) {

							ICompositeType compositeType2 = (ICompositeType) ftype;
							IField[] fields2 = compositeType2.getFields();

							for (IField f : fields2) {
								IType ftype2 = f.getType();
								String fname2 = f.getName();
								if (ftype2 instanceof ITypedef) {
									ITypedef typeDef = (ITypedef) ftype2;
									IType ftypeInnerLoop = typeDef.getType();

									if (ftypeInnerLoop instanceof ITypedef) {
										ITypedef btype = (ITypedef) ftypeInnerLoop;
										IBasicType elemKind = null;

										if (btype.getType() instanceof IBasicType)
											elemKind = (IBasicType) btype
													.getType();
										else if (btype instanceof ITypedef)
											elemKind = (IBasicType) ((ITypedef) btype
													.getType()).getType();

										switch (elemKind.getKind()) {
										case eBoolean: {
											so = new SymBoolOrig(newfieldname);
											break;
										}
										case eChar: {
											so = new SymPointerOrig(
													newfieldname);
											break;
										}
										case eInt: {
											so = new SymIntOrig(newfieldname);

											so1 = (SymIntSSA) ps.declareLocal(
													eSymType.SymInt, null);
											sc.addField(so1.getOrig(), fname2);
											break;
										}
										}

									}
								}
							}

							ps.declareLocal(so);
							sc.addField(so, field.getName());
						} else if (ftype instanceof ITypedef) {
							ITypedef btype = (ITypedef) ftype;

							IBasicType elemKind = null;

							if (btype.getType() instanceof IBasicType)
								elemKind = (IBasicType) btype.getType();
							else if (btype instanceof ITypedef)
								elemKind = (IBasicType) ((ITypedef) btype
										.getType()).getType();

							switch (elemKind.getKind()) {
							case eBoolean: {
								so = new SymBoolOrig(newfieldname);
								so = (SymBoolOrig) ps.declareLocal(
										so.getSymType(), null);
								sc.addField(so, fname);
								break;
							}
							case eChar: {
								so = new SymPointerOrig(newfieldname);
								so = (SymPointerOrig) ps.declareLocal(
										so.getSymType(), null);
								sc.addField(so, fname);
								break;
							}
							case eInt: {
								so = new SymIntOrig(newfieldname);
								so1 = (SymIntSSA) ps.declareLocal(
										so.getSymType(), null);
								sc.addField(so1.getOrig(), fname);
								break;
							}
							}

						}
					}
					// service added here
					AttrSymComposite asymc = new AttrSymComposite(sc);
					attrList.add(
							((IASTElaboratedTypeSpecifier) dspec).getName(),
							asymc);
				}
				// the struct will be added as a pointer
				symType = eSymType.SymPointer;
				break;
			}
			case IASTElaboratedTypeSpecifier.k_union: {
				System.out.println("dspec k_union" + dspec.getRawSignature());
				// to do
				break;
			}
			default: { // t_char, t_int
				System.out.println("dspec default" + dspec.getRawSignature());
				symType = eSymType.SymInt;
			}
			}
			// struct sockaddr_in is added here
			AttrDeclType declType = new AttrDeclType(symType);
			attrList.add(dspec, declType);
		} else if (dspec instanceof IASTSimpleDeclSpecifier) {
			IASTSimpleDeclSpecifier sdspec = (IASTSimpleDeclSpecifier) dspec;
			int type = sdspec.getType();
			eSymType symType;
			switch (type) {
			case IASTSimpleDeclSpecifier.t_bool: {
				symType = eSymType.SymBool;
				break;
			}
			case IASTSimpleDeclSpecifier.t_void: {
				symType = eSymType.Void;
				break;
			}
			default: { // t_char, t_int
				symType = eSymType.SymInt;
			}
			}
			AttrDeclType declType = new AttrDeclType(symType);
			attrList.add(dspec, declType);
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTDeclarator decl) {
		IASTName name = decl.getName();
		AttrName attrName = new AttrName(name);
		attrList.add(decl, attrName);
		IASTInitializer ini = decl.getInitializer();
		if (decl instanceof IASTArrayDeclarator) {
			IASTArrayDeclarator adecl = (IASTArrayDeclarator) decl;
			IASTArrayModifier[] mods = adecl.getArrayModifiers();
			for (IASTArrayModifier mod : mods) {
				// TODO: list
				AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(mod,
						"symvar");
				attrList.add(decl, asymvar);
			}
		} else if (decl instanceof IASTFunctionDeclarator) {
			// e.g. function pointer
			IASTStandardFunctionDeclarator stdFDecl = (IASTStandardFunctionDeclarator) decl;
			IASTDeclarator ndecl = stdFDecl.getNestedDeclarator();
			name = ndecl.getName();
			if (ini != null) {
				AttrFunction af = (AttrFunction) attrList.getAttribute(ini,
						"function");
				SymFctPointerSSA sfp_ssa = (SymFctPointerSSA) ps.declareLocal(
						eSymType.SymFctPointer, name);
				SymFctPointer sfp = (SymFctPointer) sfp_ssa.getOrig();
				sfp_ssa.setTarget(af.getBinding());
				sfp_ssa.setFunctionName(af.getASTName());
			}
			// TODO return PROCESS_CONTINUE ?, clarify with
			// leave(IASTDeclaration)
			return PROCESS_ABORT;
		} else {
			if (ini != null) {
			}
			IASTPointerOperator[] ptrOps = decl.getPointerOperators();
			if (Array.getLength(ptrOps) > 0) {
				attrList.add(decl, new AttrPointer());
			}
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTArrayModifier am) {
		IASTExpression sexpr = am.getConstantExpression();
		if (sexpr != null) {
			AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(sexpr,
					"symvar");
			attrList.add(am, asymvar);
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTPointerOperator ptrop) {
		return PROCESS_CONTINUE;
	}

	public int leave(IASTInitializer ini) {
		if (ini instanceof IASTInitializerList) {
			IASTInitializerClause clauses[] = ((IASTInitializerList) ini)
					.getClauses();
			for (IASTInitializerClause claus : clauses) {
				// TODO: list
				AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(claus,
						"symvar");
				attrList.add(ini, asymvar);
			}
		} else if (ini instanceof IASTEqualsInitializer) {
			IASTEqualsInitializer eqini = (IASTEqualsInitializer) ini;
			IASTInitializerClause inicl = eqini.getInitializerClause();
			ITrxAttribute attr = (ITrxAttribute) attrList.getAttribute(inicl,
					"symvar");
			if (attr != null) {
				attrList.add(ini, attr);
			} else {
				attr = (ITrxAttribute) attrList.getAttribute(inicl, "function");
				if (attr != null) {
					attrList.add(ini, attr);
				}
			}
		}
		return PROCESS_CONTINUE;
	}

	public int leave(IASTParameterDeclaration pdecl) {
		// anything todo?
		return PROCESS_CONTINUE;
	}

	public int leave(IASTExpression expr) {
		IType etype = expr.getExpressionType();
		if (expr instanceof IASTFieldReference) {
			// TODO generalize!
			IASTFieldReference fref = (IASTFieldReference) expr;
			IASTName fname = fref.getFieldName();
			IASTExpression fowner = fref.getFieldOwner();
			boolean isDeref = fref.isPointerDereference();
			SymVarOrig fieldorig;
			SymVarSSA fieldssa = null;
			SymComposite sc = null;
			// from master branch
			if (fowner.getChildren().length > 1) {
				IASTNode[] children = fowner.getChildren();
				fowner = (IASTExpression) children[0];
			}
			//
			if (isDeref) {
				SymPointerSSA pssa;
				AttrSymVar asv = (AttrSymVar) attrList.getAttribute(fowner,
						"symvar");
				pssa = (SymPointerSSA) asv.getSymVar();
				sc = (SymComposite) pssa.getTarget();
			} else {
				AttrSymComposite asc = (AttrSymComposite) attrList
						.getAttribute(fowner, "symcomposite");
				sc = asc.getSymComposite();
			}
			fieldorig = sc.getFieldOrig(fname.toString());
			fieldssa = fieldorig.getCurrentSSACopy();
			if (fieldssa == null) {
				fieldssa = ps.ssaCopy(fieldorig);
			}
			AttrSymVar asymvar = new AttrSymVar(fieldssa);
			attrList.add(expr, asymvar);
		}
		if (expr instanceof IASTFunctionCallExpression) {
			// vasantha added from info flow
			Mgetenv me = new Mgetenv(ps);
			ArrayList<FunctionComment> fcom = me.comment.getFunctionComments();
			ArrayList<ParameterComment> fpar = me.comment
					.getParameterComments();

			String call = expr.getRawSignature().toString();
			ps.notifyCryptoCall(call);
			ps.notifyOperationOnResourceInWrongPhaseOfLifetime(call);

			SymFunctionReturn sfr = ps.getNextRVal();
			IASTExpression fcexpr = ((IASTFunctionCallExpression) expr)
					.getFunctionNameExpression();
			IASTName fname = null;
			if (fcexpr instanceof IASTIdExpression) {
				fname = ((IASTIdExpression) fcexpr).getName();
			} else if (fcexpr instanceof IASTFieldReference) {
				AttrSymVar asv = (AttrSymVar) attrList.getAttribute(fcexpr,
						"symvar");
				SymFctPointerSSA fctp = (SymFctPointerSSA) asv.getSymVar();
				fname = fctp.getFctName();
			}
			fcnames.add(fname);
			IFunction binding = null;
			// vasantha added from info flow
			IASTInitializerClause inicllist2[] = ((IASTFunctionCallExpression) expr)
					.getArguments();
			IASTExpression pexpr = ((IASTFunctionCallExpression) expr)
					.getParameterExpression();
			if (pexpr != null) {
				AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(pexpr,
						"symvar");
				if (asymvar != null) {
					SymVarSSA ssa = asymvar.getSymVar();
					for (int i = 0; i < inicllist2.length; i++) {
						// main logic
						if (ssa.isConfidential()) {
							setStatus(true);
						}
					}
				}
			}
			// /
			binding = (IFunction) fname.resolveBinding();
			if (ps.existsLocalOrigSymVar(fname)) {
				// fct pointer
				SymFctPointerSSA sfp_ssa = (SymFctPointerSSA) ps
						.resolveOrigSymVar(fname).getCurrentSSACopy();
				binding = (IFunction) sfp_ssa.getTarget();
				fname = sfp_ssa.getFctName();
			} else {
				binding = (IFunction) fname.resolveBinding();
			}
			if (ps.isProjectLocalFct(binding)) {
				if (sfr != null) {
					// returning
					ps.clearNextRVal();
					ps.popSymFctSign();
					if (sfr.hasRVal()) {
						SymVarSSA ssaCopy = sfr.getRVal();
						AttrSymVar asymvar = new AttrSymVar(ssaCopy);
						attrList.add(expr, asymvar);
					}
					return PROCESS_CONTINUE;
				} else {
					SymFctSignature fsign = ps.getSymFctSign(binding);
					SymFunctionCall fcall = new SymFunctionCall(fname);
					IASTInitializerClause inicllist[] = ((IASTFunctionCallExpression) expr)
							.getArguments();
					ArrayList<ISymObject> symptypes = fsign.getParams();
					int i = 0;
					for (ISymObject spt : symptypes) {
						IASTInitializerClause icl = inicllist[i];
						i++;
						if (spt instanceof SymVarOrig) {
							AttrSymVar asymvar = (AttrSymVar) attrList
									.getAttribute(icl, "symvar");
							if (asymvar != null) {
								SymVarSSA ssa = asymvar.getSymVar();
								fcall.addParam(ssa.getOrigName());
							} else {
								AttrFunction afct = (AttrFunction) attrList
										.getAttribute(icl, "function");
								SymFctPointerSSA sfssa = (SymFctPointerSSA) ps
										.declareLocal(eSymType.SymFctPointer,
												null);
								SymFctPointer sfo = (SymFctPointer) sfssa
										.getOrig();
								IFunction fctbinding = (IFunction) afct
										.getBinding();
								IASTName fctname = afct.getASTName();
								sfssa.setTarget(fctbinding);
								sfssa.setFunctionName(fctname);
								fcall.addParam(sfssa.getOrigName());
							}
						} else if (spt instanceof SymComposite) {
							AttrSymComposite asymcomp = (AttrSymComposite) attrList
									.getAttribute(icl, "symcomposite");
							SymComposite sc = asymcomp.getSymComposite();
							fcall.addParam(sc.getName());
						}
					}
					ps.regFunctionCall(fcall);
					return PROCESS_ABORT;
				}
			} else { // external call
				IASTFunctionCallExpression fexpr = (IASTFunctionCallExpression) expr;
				SymFctSignature fsign = ps.getLibSymFctSign(fname.toString());
				SymFunctionCall fcall = new SymFunctionCall(fname);
				IASTInitializerClause[] inicllist = fexpr.getArguments();
				ArrayList<ISymObject> symptypes = fsign.getParams();
				// vasantha from master
				// int i=0;
				// for (ISymObject spt : symptypes) {
				// vasantha made this change
				for (int i = 0; i < symptypes.size() && i < inicllist.length; i++) {
					IASTInitializerClause icl = inicllist[i];
					AttrSymVar asymvar = (AttrSymVar) attrList.getAttribute(
							icl, "symvar");
					AttrFunction afct = (AttrFunction) attrList.getAttribute(
							icl, "function");

					// /vasantha added

					// SymVarSSA ssa = asymvar.getSymVar();
					// IName orig_name = ssa.getOrigName();
					// if (ps.existsLocalOrigSymVar(orig_name)) {
					// ssa.setConfidential(true);
					// }
					// TODO symcomposite
					if (asymvar != null) {
						SymVarSSA ssaCopy = asymvar.getSymVar();
						eSymType symtyp = ssaCopy.getESymType();
						if (symtyp == eSymType.SymArray) {
							// pass as pointer
							SymPointerSSA sps = (SymPointerSSA) ps
									.declareLocal(eSymType.SymPointer, null);
							SymPointerOrig spo = (SymPointerOrig) sps.getOrig();
							sps.setTargetType(eSymType.SymArray);
							SymVarOrig orig = ps.resolveOrigSymVar(ssaCopy
									.getOrigName());
							sps.setTarget(orig);
							sps.addDependency(ssaCopy);
							// vasantha
							fcall.addParam(spo.getOrigName());

							// fcall.addParam(sps.getOrigName());
						} else {
							fcall.addParam(ssaCopy.getOrigName());
						}
					} else if (afct != null) {
						IName fctname = afct.getASTName();
						fcall.addParam(fctname);
					}
				}
				// /here is the return type of that functional call is accessed
				// vasantha
				SymFunctionReturn sret = ps.extFctCall(fcall);
				if (sret.hasRVal()) {
					SymVarSSA rval = sret.getRVal();
					AttrSymVar asymvar = new AttrSymVar(rval);
					attrList.add(expr, asymvar);
				}
			}
		}
		if (expr instanceof IASTIdExpression) {
			// TODO: move everything to interpreter resolve function?
			IASTIdExpression idex = (IASTIdExpression) expr;
			IASTName iastName = idex.getName();
			ITrxAttribute attr = null;
			if (etype instanceof IFunctionType) {
				IBinding function = iastName.resolveBinding();
				attr = new AttrFunction(iastName, function);

			}
			// vasantha added from master
			else if (etype instanceof ICompositeType) {
				SymComposite sc = ps.getLocalSymComposite(iastName);
				if (sc != null) {
					attr = new AttrSymComposite(sc);
				}
			} else if (ps.isGlobalScopeVar(iastName)) {
				if (ps.existsGlobalOrigSymVar(iastName)) {
					SymVarSSA ssaCopy = ps.getGlobalOrigSymVar(iastName)
							.getCurrentSSACopy();
					if (ps.isMTA()) {
						SymVarOrig svo = ssaCopy.getOrig();
						svo.setShared();
					}
					attr = new AttrSymVar(ssaCopy);
				} else {
					// isStatic?
					// declare and get init value
					IBinding binding = iastName.resolveBinding();
					IType rtype = null;
					IValue initval = null;

					// vasantha added from master
					if (binding instanceof IVariable) {
						//
						IVariable var = (IVariable) binding;
						initval = var.getInitialValue();

						if (!var.isStatic() && (initval == null)) { // external
							IndexLocker indexLocker = ps.getIndexLocker();
							IIndexBinding ib = null;
							try {
								indexLocker.lock();
								ib = indexLocker.getIndex().adaptBinding(
										binding);
							} finally {
								indexLocker.unlock();
							}
							var = (IVariable) ib;
							initval = var.getInitialValue();
						}

						rtype = var.getType();
					}

					if (binding instanceof IEnumerator) {
						IBinding binding2 = iastName.getBinding();
						IEnumerator var1 = (IEnumerator) binding2;
						// var = (IVariable) binding2;
						initval = var1.getValue();

						// var is static in an enumeration
						if (initval == null) { // external
							IIndexBinding ib = ps.getIndexLocker().getIndex()
									.adaptBinding(binding);
							var1 = (IEnumerator) ib;
							initval = var1.getValue();
						}
						rtype = (IType) var1.getType();
					}
					IBasicType btype = null;
					SymVarSSA ssa = null;
					IType targetType = null;
					if (btype != null) {
						switch (btype.getKind()) {
						case eInt: {
							ps.declareGlobal(eSymType.SymInt, iastName);
							ssa = (SymIntSSA) ps.getGlobalOrigSymVar(iastName)
									.getCurrentSSACopy();
							if (initval != null) {
								ssa.setFormula(new String("(assert (= "
										+ ssa.getSSAName() + " " + initval
										+ " ))"));
							}
						}
						}
						attr = new AttrSymVar(ssa);

					}
					// vasantha
					ISymObject so = SymTypeBuilder.getInstance()
							.buildDeclareInit(ps, iastName, etype, initval,
									true);

					if (so != null) {
						switch (so.getSymType()) {
						case SymComposite: {
							attr = new AttrSymComposite((SymComposite) so);
							break;
						}
						default: {
							attr = new AttrSymVar((SymVarSSA) so);
							if (ps.isMTA()) {
								SymVarOrig svo = ((SymVarSSA) so).getOrig();
								svo.setShared();
							}
							break;
						}
						}
					}
				}
			} else if (ps.existsLocalOrigSymVar(iastName)) { // IBasicType
				SymVarSSA ssaCopy = ps.resolveOrigSymVar(iastName)
						.getCurrentSSACopy();
				attr = new AttrSymVar(ssaCopy);
			} else if (ps.getLocalSymComposite(iastName) != null) {
				// TODO: unique resolve function for SymVars and SymComposites !
				SymComposite sc = ps.getLocalSymComposite(iastName);
				attr = new AttrSymComposite(sc);
			} else {
				// declare local
				ISymObject so = SymTypeBuilder.getInstance().buildDeclareInit(
						ps, iastName, etype, null, false);

				if (so != null) {
					switch (so.getSymType()) {
					case SymComposite: {
						attr = new AttrSymComposite((SymComposite) so);
						break;
					}
					default: {
						attr = new AttrSymVar((SymVarSSA) so);
						// vasantha added from master
						if (ps.isMTA()) {
							SymVarOrig svo = ((SymVarSSA) so).getOrig();
							svo.setShared();
						}
						break;
					}

					}
				}
			}
			attrList.add(expr, attr);
		}
		if (expr instanceof IASTLiteralExpression) {
			IASTLiteralExpression lexpr = (IASTLiteralExpression) expr;
			String sval = lexpr.toString();
			int valuetype = lexpr.getKind();
			SymVarSSA ssa_copy = null;
			switch (valuetype) {
			case (IASTLiteralExpression.lk_string_literal): {
				// remove '"' '"'
				sval = sval.substring(1, sval.length() - 1);
				SymIntSSA sao_size_ssa = (SymIntSSA) ps.declareLocal(
						eSymType.SymInt, null);
				SymIntOrig sao_size = (SymIntOrig) sao_size_ssa.getOrig();
				ssa_copy = (SymArraySSA) ps.declareLocal(eSymType.SymArray,
						null);
				SymArrayOrig sao = (SymArrayOrig) ssa_copy.getOrig();
				sao.setSize(sao_size);
				sao.setElemType(eSymType.SymInt);
				String sao_formula = "(assert (= "
						+ sao_size.getCurrentSSACopy().getSSAName() + " "
						+ sval.length() + " ))";
				sao_size.getCurrentSSACopy().setFormula(sao_formula);
				StringBuffer sbuf = new StringBuffer();
				for (int i = 0; i < sval.length(); i++) {
					// one formula line per new array entry
					Integer charval = Character.getNumericValue(sval.charAt(i));
					String charNumForm = null;
					if (charval < 0) {
						// filter negatives
						charNumForm = new String("(- 0 "
								+ charval.toString().substring(1) + ")");
					} else {
						charNumForm = new String(Integer.toString(charval));
					}
					String addChar = new String("(assert (= "
							+ ssa_copy.getSSAName() + " ( store "
							+ ssa_copy.getSSAName() + " " + i + " "
							+ charNumForm + " )))\n");
					sbuf.append(addChar);
				}
				ssa_copy.setFormula(sbuf.toString());
				break;
			}
			case (IASTLiteralExpression.lk_nullptr):
				break;
			case (IASTLiteralExpression.lk_true):
				break;
			case (IASTLiteralExpression.lk_false):
				break;
			case (IASTLiteralExpression.lk_float_constant):
				break;
			case (IASTLiteralExpression.lk_char_constant): { // TODO
				// remove
				// code
				// duplicate
				// with
				// lk_string_literal
				ssa_copy = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
				SymIntOrig si = (SymIntOrig) ssa_copy.getOrig();
				Integer charval = Character.getNumericValue(sval.charAt(0));
				String charNumForm = null;
				if (charval < 0) {
					// filter negatives
					charNumForm = new String("(- 0 "
							+ charval.toString().substring(1) + ")");
				} else {
					charNumForm = new String(Integer.toString(charval));
				}
				ssa_copy.setFormula(new String("(assert (= "
						+ ssa_copy.getSSAName() + " " + charNumForm + " ))"));
				break;

			}
			case (IASTLiteralExpression.lk_integer_constant): {
				ssa_copy = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
				ssa_copy.setFormula(new String("(assert (= "
						+ ssa_copy.getSSAName() + " " + sval + " ))"));
				break;
			}
			}
			AttrSymVar asymvar = new AttrSymVar(ssa_copy);
			attrList.add(expr, asymvar);
		}

		if (expr instanceof IASTUnaryExpression) {
			IASTUnaryExpression unexp = (IASTUnaryExpression) expr;
			int unop = unexp.getOperator();
			IASTExpression op = unexp.getOperand();
			String opsymbol = null;
			String sformula = null;
			AttrSymVar asymvar1 = (AttrSymVar) attrList.getAttribute(op,
					"symvar");
			AttrSymComposite asymcomposite1 = (AttrSymComposite) attrList
					.getAttribute(op, "symcomposite");
			if (unop == IASTUnaryExpression.op_bracketedPrimary) { // extra
				// brackets...
				if (asymvar1 != null) {
					attrList.add(expr, asymvar1);
					return PROCESS_CONTINUE;
				}
				if (asymcomposite1 != null) {
					attrList.add(expr, asymcomposite1);
					return PROCESS_CONTINUE;
				}
			} else if (unop == IASTUnaryExpression.op_amper) {
				// generate and declare sympointer

				if (asymcomposite1 != null) {
					attrList.add(expr, asymcomposite1);
					return PROCESS_CONTINUE;
				}
				//
				else {
					SymVarSSA targetSSA = asymvar1.getSymVar();
					SymVarOrig targetOrig = (SymVarOrig) targetSSA.getOrig();
					SymPointerSSA sp_ssa = (SymPointerSSA) ps.declareLocal(
							eSymType.SymPointer, null);
					SymPointerOrig sp = (SymPointerOrig) sp_ssa.getOrig();
					if (targetOrig.getSymType() == eSymType.SymPointer) {
						SymPointerSSA oldspssa = (SymPointerSSA) targetSSA;
						sp.setLevel(oldspssa.getLevel() + 1);
						// TODO targetType?
					} else {
						sp.setLevel(1);
						sp.setTargetType(targetOrig.getSymType());
					}
					sp_ssa.setTarget(targetOrig);
					AttrSymVar asymvar = new AttrSymVar(sp_ssa);
					attrList.add(expr, asymvar);
					return PROCESS_CONTINUE;
				}
			} else if (unop == IASTUnaryExpression.op_star) {
				// deref pointer
				SymPointerSSA sp_ssa = (SymPointerSSA) asymvar1.getSymVar();
				SymVarSSA target = sp_ssa.getTargetSSA();
				if (ps.isMTA()) {
					if (sp_ssa.getOrig().isShared()) {
						target.getOrig().setShared();
					}
				}
				AttrSymVar asymvar = new AttrSymVar(target);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
			} else if (unop == IASTUnaryExpression.op_sizeof) {
				// FIXME: more accurate op_sizeof model
				// possibly introduce machine model parameters for
				// sizeof()
				// formula
				// current: for SymArray return number of elements, for
				// SymInt
				// and SymPointer return 1. for SymComposite sum formula
				// for SymArray dep only on SymArray.sizeSymInt
				// move sizeof counts to SymVars ? (or to new
				// memory-model
				// class?)
				SymIntSSA si_ssa = (SymIntSSA) ps.declareLocal(eSymType.SymInt,
						null);
				SymIntOrig si = (SymIntOrig) si_ssa.getOrig();
				if (asymvar1 != null) {
					String res = null;
					SymVarSSA ssa = asymvar1.getSymVar();
					eSymType esymtyp = ssa.getESymType();
					if (esymtyp == eSymType.SymArray) {
						SymArraySSA arrssa = (SymArraySSA) ssa;
						res = arrssa.getSize();
						si_ssa.addDependency(arrssa.getSizeSymInt());
					} else {
						res = new String("1");
						si_ssa.addDependency(ssa);
					}
					si_ssa.setFormula(new String("(assert (= "
							+ si_ssa.getSSAName() + " " + res + " ))"));
				} else if (asymcomposite1 != null) {
					// sum components
					SymComposite sc = asymcomposite1.getSymComposite();
					ArrayList<SymVarOrig> components = sc.getFields();
					ArrayList<String> rescomp = new ArrayList<String>();
					for (SymVarOrig svo : components) {
						String rc = null;
						SymVarSSA ssa = svo.getCurrentSSACopy();
						eSymType esymtyp = ssa.getESymType();
						if (esymtyp == eSymType.SymArray) {
							SymArraySSA arrssa = (SymArraySSA) ssa;
							rc = arrssa.getSize();
							rescomp.add(rc);
							si_ssa.addDependency(arrssa.getSizeSymInt());
						} else {
							rc = new String("1");
							rescomp.add(rc);
						}
					}
					StringBuffer scres = new StringBuffer();
					scres.append(rescomp.get(0));
					for (int i = 1; i < components.size(); i++) {
						scres.insert(0, "(+ ");
						scres.append(" " + rescomp.get(i));
						scres.append(" )");
					}
					scres.insert(0, "(assert (= " + si_ssa.getSSAName() + " ");
					scres.append(" ) )");
					si_ssa.setFormula(scres.toString());
				}
				AttrSymVar asymvar = new AttrSymVar(si_ssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
				// endif op_sizeof
			} else if (unop == IASTUnaryExpression.op_postFixIncr
					|| unop == IASTUnaryExpression.op_prefixIncr) {
				SymVarSSA ssa = asymvar1.getSymVar();
				IName origname = ssa.getOrigName();
				SymVarSSA newssa = null;
				if (ps.existsLocalOrigSymVar(origname)) {
					SymVarOrig orig = ps.resolveOrigSymVar(origname);
					newssa = ps.ssaCopy(orig);
				} else {
					newssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
				}
				sformula = new String("(assert (= " + newssa.getSSAName()
						+ " (+ " + ssa.getSSAName() + " 1 )))");
				newssa.setFormula(sformula);
				newssa.addDependency(ssa);
				AttrSymVar asymvar = new AttrSymVar(newssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
			} else if (unop == IASTUnaryExpression.op_postFixDecr
					|| unop == IASTUnaryExpression.op_prefixDecr) {
				SymVarSSA ssa = asymvar1.getSymVar();
				IName origname = ssa.getOrigName();
				SymVarSSA newssa = null;
				if (ps.existsLocalOrigSymVar(origname)) {
					SymVarOrig orig = ps.resolveOrigSymVar(origname);
					newssa = ps.ssaCopy(orig);
				} else {
					newssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
				}
				sformula = new String("(assert (= " + newssa.getSSAName()
						+ " (- " + ssa.getSSAName() + " 1 )))");
				newssa.setFormula(sformula);
				newssa.addDependency(ssa);
				AttrSymVar asymvar = new AttrSymVar(newssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
			} else if (unop == IASTUnaryExpression.op_not) {
				SymVarSSA ssa = asymvar1.getSymVar();
				SymVarSSA newssa = null;
				String formula = null;
				IName origname = ssa.getOrigName();
				SymVarOrig so = ps.resolveOrigSymVar(origname);
				switch (so.getSymType()) {
				case SymBool: {
					newssa = (SymVarSSA) ps
							.declareLocal(eSymType.SymBool, null);
					SymBoolOrig sbo = (SymBoolOrig) newssa.getOrig();
					formula = new String("(assert (= " + newssa.getSSAName()
							+ " (not " + ssa.getSSAName() + " )))");
					break;
				}
				case SymInt: {
					// type promotion to Bool
					newssa = (SymVarSSA) ps
							.declareLocal(eSymType.SymBool, null);
					SymBoolOrig sbo = (SymBoolOrig) newssa.getOrig();
					formula = new String("(assert (= " + newssa.getSSAName()
							+ " (not (distinct " + ssa.getSSAName() + " 0 ))))");
					break;
				}
				}
				newssa.setFormula(formula);
				newssa.addDependency(ssa);
				AttrSymVar asymvar = new AttrSymVar(newssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
			} else {
				SymVarSSA ssa = asymvar1.getSymVar();
				IName origname = ssa.getOrigName();
				SymVarSSA newssa = null;
				IBasicType.Kind restype = OpTranslator.unOpResType(unop);
				if (ps.existsLocalOrigSymVar(origname)) {
					SymVarOrig orig = ps.resolveOrigSymVar(origname);
					newssa = ps.ssaCopy(orig);
				} else {
					newssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
				}
				sformula = new String("(assert (= " + newssa.getSSAName()
						+ " ( " + OpTranslator.unaryOp(unop) + " "
						+ ssa.getSSAName() + " )))");
				newssa.setFormula(sformula);
				newssa.addDependency(ssa);
				AttrSymVar asymvar = new AttrSymVar(newssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;
			}
		}

		if (expr instanceof IASTBinaryExpression) {
			IASTBinaryExpression binexp = (IASTBinaryExpression) expr;
			IASTExpression operandLeft = binexp.getOperand1();
			IASTExpression operandRight = binexp.getOperand2();
			int binop = binexp.getOperator();
			AttrSymVar tempAsymVar = null;
			AttrSymVar aSymVarLeft = (AttrSymVar) attrList.getAttribute(
					operandLeft, "symvar");
			if (aSymVarLeft == null) {
				return 0;
			}
			SymVarSSA symVarLeft = aSymVarLeft.getSymVar();
			AttrSymVar aSymVarRight = (AttrSymVar) attrList.getAttribute(
					operandRight, "symvar");
			SymVarSSA symVarRight = aSymVarRight.getSymVar();
			// vasantha added from master
			String str1 = expr.getRawSignature().toString();

			if (str1.contains("(int*)args")) {
				System.out.println();
			}

			IASTNode[] opExpr = binexp.getChildren();
			IASTNode[] nestedExpr;
			IASTNode tempExpr = null;
			for (int i = 0; i < opExpr.length; i++) {
				IASTNode checkNull[] = opExpr[i].getChildren();
				if (checkNull != null) {
					if (opExpr[i].getChildren().length > 1) {
						nestedExpr = opExpr[i].getChildren();

						try {
							while (nestedExpr[nestedExpr.length - 1]
									.getChildren().length > 1) {
								try {
									nestedExpr = nestedExpr[nestedExpr.length - 1]
											.getChildren();
									if (nestedExpr[nestedExpr.length - 1] != null) {
										tempExpr = nestedExpr[nestedExpr.length - 1];
									}
								} catch (Exception e) {
								}
							}
							tempAsymVar = (AttrSymVar) attrList.getAttribute(
									tempExpr, "symvar");
							// getting the left child
							if (tempExpr != null) {
								if (i == 0) {
									operandLeft = (IASTExpression) tempExpr;
									symVarLeft = tempAsymVar.getSymVar();
								} else // getting the right child
								{
									operandRight = (IASTExpression) tempExpr;
									symVarRight = tempAsymVar.getSymVar();
								}
							}
						} catch (Exception e) {
						}
					}
				}
			}

			// this is used for storring the current upper bound value
			// for
			// CWE-190
			ps.updateLimit(operandLeft.getRawSignature(),
					operandRight.getRawSignature());
			//
			if (ps.isMTA()) {
				if (binop == IASTBinaryExpression.op_assign
						&& symVarLeft.getOrig().isShared()) {
					IName name1 = symVarLeft.getOrigName();
					if (name1 instanceof IASTName) {
						IBinding var = ((IASTName) name1).resolveBinding();
						ps.notifySMemDef(var);
					}
				} else if (symVarLeft.getOrig().isShared()) {
					IName name1 = symVarLeft.getOrigName();
					if (name1 instanceof IASTName) {
						ps.notifySMemUse((IASTName) name1);
					}
				}
				if (symVarRight.getOrig().isShared()) {
					IName name2 = symVarRight.getOrigName();
					if (name2 instanceof IASTName) {
						ps.notifySMemUse((IASTName) name2);
					}
				}
			}
			if (binop == IASTBinaryExpression.op_assign) {
				// assign to current ssa of left-side SymVarOrig
				// maybe move to SymPointerSSA copy method?
				System.out.println();
				SymVarOrig origAssignee = symVarLeft.getOrig();
				if (symVarLeft.getESymType() == eSymType.SymPointer
						&& symVarRight.getESymType() == eSymType.SymPointer) {

					SymVarSSA ssaAssignee = ps.ssaCopy(origAssignee);
					SymPointerSSA res = (SymPointerSSA) ssaAssignee;
					SymPointerSSA source = (SymPointerSSA) symVarRight;
					res.setLevel(source.getLevel());
					res.setTargetType(source.getESymType());
					res.setTarget(source.getTarget());
					res.addDependency(source);
					AttrSymVar asymvar = new AttrSymVar(res);
					attrList.add(expr, asymvar);
					return PROCESS_CONTINUE;
				} else if ((symVarLeft.getESymType() == eSymType.SymPointer)
						&& (symVarRight.getESymType() != eSymType.SymPointer)) {
					SymPointerSSA sps = (SymPointerSSA) symVarLeft;
					if (sps.getTarget() != null) {
						eSymType targetsymtype = sps.getTargetSSA()
								.getESymType();
						switch (targetsymtype) {
						case SymArray: {
							// new array version necessary
							SymArraySSA oldssa = (SymArraySSA) sps
									.getTargetSSA();
							SymArrayOrig sao = ps.getLocalOrigSymArray(oldssa
									.getOrigName());
							SymArraySSA newssa;
							if (oldssa.isInitialized()) {
								newssa = (SymArraySSA) ps.ssaCopy(sao);
							} else {
								newssa = oldssa;
							}
							String index = sps.getSSAName();
							String value = symVarRight.getSSAName();
							String formula = new String("(assert (= "
									+ newssa.getSSAName() + " (store "
									+ oldssa.getSSAName() + " " + index + " "
									+ value + " )))");
							newssa.setFormula(formula);
							newssa.addDependency(oldssa);
							newssa.addDependency(symVarRight);
							newssa.addDependency(sps);
							AttrSymVar asymvar = new AttrSymVar(newssa);
							attrList.add(expr, asymvar);
							ps.notifyMemWrite(sps);
							return PROCESS_CONTINUE;
						}
						}
					}
				} else if (symVarLeft.getESymType() == eSymType.SymFctPointer
						&& symVarRight.getESymType() == eSymType.SymFctPointer) {
					SymFctPointerSSA newssa = (SymFctPointerSSA) ps
							.ssaCopy(symVarLeft.getOrig());
					newssa.setTarget(((SymFctPointerSSA) symVarRight)
							.getTarget());
					newssa.setFunctionName(((SymFctPointerSSA) symVarRight)
							.getFctName());
					AttrSymVar asymvar = new AttrSymVar(newssa);
					attrList.add(expr, asymvar);
					return PROCESS_CONTINUE;
				} else {
					if (symVarLeft.isInitialized()) {
						symVarLeft = ps.ssaCopy(symVarLeft.getOrig());

					}
					String formula = new String("(assert (= "
							+ symVarLeft.getSSAName() + " "
							+ symVarRight.getSSAName() + "))");
					symVarLeft.setFormula(formula);
					symVarLeft.addDependency(symVarRight);
					AttrSymVar asymvar = new AttrSymVar(symVarLeft);

					attrList.add(expr, asymvar);
					return PROCESS_CONTINUE;
				}
			} else if (binop == IASTBinaryExpression.op_lessEqual) {

				if ((symVarLeft.getESymType() == eSymType.SymInt)
						&& (symVarRight.getESymType() == eSymType.SymInt)) {
					SymIntSSA sps = (SymIntSSA) symVarLeft;
					eSymType targetsymtype = symVarLeft.getESymType();
					String formula = "";
					switch (targetsymtype) {
					case SymInt: {
						// new array version necessary
						SymIntSSA oldssa = (SymIntSSA) sps;
						SymIntOrig sao = ps.getLocalOrigSymInt(oldssa
								.getOrigName());
						SymIntSSA newssa;
						if (oldssa.isInitialized()) {
							newssa = (SymIntSSA) ps.ssaCopy(sao);
							/*
							 * The following formula has been added. If a new
							 * symbolic name is used for an existing symbolic
							 * variable then we need to use the old constraints
							 * from the old symbolic variable name too. We just
							 * say the old name is = to the new name.
							 */
							formula = "(assert ( = " + symVarLeft.getSSAName()
									+ " " + newssa.getSSAName() + " ))";
						} else {
							newssa = oldssa;
						}
						formula += new String("(assert ( <= "
								+ symVarLeft.getSSAName() + " "
								+ symVarRight.getSSAName() + " ))");
						newssa.setFormula(formula);
						newssa.addDependency(symVarLeft);
						newssa.addDependency(symVarRight);
						AttrSymVar asymvar = new AttrSymVar(newssa);
						attrList.add(expr, asymvar);
						return PROCESS_CONTINUE;
					}
					}
				}
			} else if (binop == IASTBinaryExpression.op_plus) {
				System.out.println();
				if ((symVarLeft.getESymType() == eSymType.SymInt)
						&& (symVarRight.getESymType() == eSymType.SymInt)) {
					SymIntSSA sps = (SymIntSSA) symVarLeft;
					SymIntSSA spsR = (SymIntSSA) symVarRight;

					eSymType targetsymtype = symVarLeft.getESymType();
					switch (targetsymtype) {
					case SymInt: {
						// new array version necessary
						SymIntSSA oldssa = (SymIntSSA) sps;
						SymIntSSA oldssaR = (SymIntSSA) spsR;

						SymIntOrig sao = ps.getLocalOrigSymInt(oldssa
								.getOrigName());

						if (sao == null) {
							try {
								sao = (SymIntOrig) ps
										.getGlobalOrigSymVar(oldssa
												.getOrigName());

							} catch (Exception e) {
								sao = (SymIntOrig) ps
										.getLocalOrigSymVar(oldssaR
												.getOrigName());
							}
						}

						SymIntSSA newssa;
						if (oldssa.isInitialized()) {
							newssa = (SymIntSSA) ps.ssaCopy(sao);
						} else {
							newssa = oldssa;
						}

						String formula = ("(assert ( = ( + "
								+ symVarRight.getSSAName() + " "
								+ symVarLeft.getSSAName() + " ) "
								+ newssa.getSSAName() + " ))");
						String formula2 = newssa.getFormula();
						formula2 += "\n" + formula + "\n";

						newssa.setFormula(formula2);
						newssa.addDependency(symVarLeft);
						newssa.addDependency(symVarRight);
						newssa.addDependency(sps);

						AttrSymVar asymvar = new AttrSymVar(newssa);
						attrList.add(expr, asymvar);

						return PROCESS_CONTINUE;
					}
					}
				}
			} else if (binop == IASTBinaryExpression.op_multiply) {

				if ((symVarLeft.getESymType() == eSymType.SymInt && symVarRight
						.getESymType() == eSymType.SymInt)) {

					SymIntSSA sps = (SymIntSSA) symVarLeft;
					eSymType targetsymtype = symVarLeft.getESymType();

					switch (targetsymtype) {

					case SymInt: {
						// new array version necessary
						SymIntSSA oldssa = (SymIntSSA) sps;
						SymIntOrig sao = ps.getLocalOrigSymInt(oldssa
								.getOrigName());
						SymIntSSA newssa;
						if (oldssa.isInitialized()) {
							newssa = (SymIntSSA) ps.ssaCopy(sao);
						} else {
							newssa = oldssa;
						}
						newssa.setFormula("(assert ( = ( * "
								+ symVarRight.getSSAName() + " "
								+ symVarLeft.getSSAName() + " ) "
								+ newssa.getSSAName() + " ))");
						newssa.addDependency(symVarLeft);
						newssa.addDependency(symVarRight);
						newssa.addDependency(sps);

						AttrSymVar asymvar = new AttrSymVar(newssa);
						attrList.add(expr, asymvar);
						return PROCESS_CONTINUE;
					}
					}
				}
			} else if (binop == IASTBinaryExpression.op_notequals) {
				SymBoolSSA res_ssa = (SymBoolSSA) ps.declareLocal(
						eSymType.SymBool, null);
				SymBoolOrig res = (SymBoolOrig) res_ssa.getOrig();
				if (symVarLeft.getESymType() == eSymType.SymPointer
						&& symVarRight.getESymType() == eSymType.SymPointer) {
					String formula = ps.symPointerBinEx(binop,
							(SymPointerSSA) symVarLeft,
							(SymPointerSSA) symVarRight);

					res_ssa.setFormula(new String("(assert (= "
							+ res_ssa.getSSAName() + " " + formula + "))"));
					// TODO: cleanup
					res_ssa.addDependency(symVarLeft);
					res_ssa.addDependency(symVarRight);
				} else if (symVarLeft.getESymType() == eSymType.SymPointer
						|| symVarRight.getESymType() == eSymType.SymPointer) {

					SymPointerSSA opPointer;
					SymVarSSA opOther;
					if (symVarLeft.getESymType() == eSymType.SymPointer) {
						opPointer = (SymPointerSSA) symVarLeft;
						opOther = symVarRight;

					} else {
						opPointer = (SymPointerSSA) symVarRight;
						opOther = symVarLeft;
					}
					if (!opPointer.isInitialized) {
						// null pointer
						String formula = null;
						if (opOther.isInitialized) {
							formula = new String("(assert (= "
									+ res_ssa.getSSAName() + " true ))");
						} else {
							formula = new String("(assert (= "
									+ res_ssa.getSSAName() + " false ))");
						}
						res_ssa.setFormula(formula);
					}
				} else {
					String sformula1 = symVarLeft.getSSAName();
					String sformula2 = symVarRight.getSSAName();
					String opsymbol = OpTranslator.binaryOp(binop);
					String formula = new String("(assert (= "
							+ res_ssa.getSSAName() + " (" + opsymbol + " "
							+ sformula1 + " " + sformula2 + " )))");
					res_ssa.setFormula(formula);
					// TODO: cleanup
					res_ssa.addDependency(symVarLeft);
					res_ssa.addDependency(symVarRight);

				}
				AttrSymVar asymvar = new AttrSymVar(res_ssa);
				attrList.add(expr, asymvar);
				return PROCESS_CONTINUE;

			} else if (binop == IASTBinaryExpression.op_divide) {
				// solver currently cannot handle formulas in divisions,
				// workaraound: symbolic constant propagation

				SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt,
						null);
				SymVarOrig svo = ssa.getOrig();

				BigInteger div1 = ps.getConcreteBigInt(symVarLeft);
				BigInteger div2 = ps.getConcreteBigInt(symVarRight);

				SymIntSSA ssatemp = (SymIntSSA) ps.declareLocal(
						eSymType.SymInt, null);
				SymIntOrig temp = (SymIntOrig) ssatemp.getOrig();
				ssatemp.setFormula("(assert (= " + ssatemp.getSSAName()
						+ " (/ " + div1 + " " + div2 + " )))");

				BigInteger res = ps.getConcreteBigInt(ssatemp);

				if (!div2.equals("0")) {
					res = div1.divide(div2);
				} else {
					res = new BigInteger(ps.getConcreteInt(ssatemp).toString());
				}

				ssa.setFormula("(assert (= " + ssa.getSSAName() + " " + res
						+ " ))");
				AttrSymVar asymvar = new AttrSymVar(ssa);
				attrList.add(expr, asymvar);

			} else if (binop == IASTBinaryExpression.op_modulo) {
				// concretize to allow linear logic; TODO: only divisor
				SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt,
						null);
				SymVarOrig svo = ssa.getOrig();
				int div2 = ps.getConcreteInt(symVarRight);
				String formula = "(assert (= " + ssa.getSSAName() + "(mod "
						+ symVarLeft.getSSAName() + " " + div2 + " )))";

				ssa.setFormula(formula);
				ssa.addDependency(symVarLeft);

				AttrSymVar asymvar = new AttrSymVar(ssa);
				attrList.add(expr, asymvar);
			} else { // declare implicit ssa
				SymVarSSA ssa = null;
				SymVarOrig svo = null;
				if (etype instanceof ITypedef) {
					// TODO: recursive
					etype = ((ITypedef) etype).getType();
				}
				if (etype instanceof IBasicType) {
					IBasicType.Kind kind = ((IBasicType) etype).getKind();
					switch (kind) {
					case eBoolean: {
						ssa = (SymVarSSA) ps.declareLocal(eSymType.SymBool,
								null);
						break;
					}
					case eChar:
					case eInt: {
						if (OpTranslator.binOpResType(binop) == IBasicType.Kind.eBoolean) {
							// e.g. nonzero -> 1, zero -> 0
							kind = IBasicType.Kind.eBoolean;
							ssa = (SymVarSSA) ps.declareLocal(eSymType.SymBool,
									null);
						} else {
							ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt,
									null);
							break;
						}
					}
					}
				} else if (etype instanceof IPointerType) {
					ssa = (SymVarSSA) ps
							.declareLocal(eSymType.SymPointer, null);
					// TODO
				} else if (etype instanceof IArrayType) {
					// TODO
				} else if (etype instanceof ICompositeType) {
					// TODO
				}
				svo = ssa.getOrig();
				if ((symVarLeft instanceof SymPointerSSA)
						&& (symVarRight instanceof SymPointerSSA)) {
					String formula = ps.symPointerBinEx(binop,
							(SymPointerSSA) symVarLeft,
							(SymPointerSSA) symVarRight);
					ssa.setFormula(new String("(assert (= " + ssa.getSSAName()
							+ " " + formula + "))"));
					AttrSymVar asymvar = new AttrSymVar(ssa);
					attrList.add(expr, asymvar);
				} else if (symVarLeft instanceof SymPointerSSA
						|| symVarRight instanceof SymPointerSSA) {

					SymPointerSSA spssa = null;
					SymIntSSA sissa = null;
					if (symVarLeft instanceof SymPointerSSA) {
						spssa = (SymPointerSSA) symVarLeft;
						sissa = (SymIntSSA) symVarRight;
					} else {
						spssa = (SymPointerSSA) symVarRight;
						sissa = (SymIntSSA) symVarLeft;

					}
					if (spssa.isInitialized()) {
						String formula = new String("(assert (= "
								+ ssa.getSSAName() + " true ))");
						ssa.setFormula(formula);
					} else {
						String formula = new String("(assert (= "
								+ ssa.getSSAName() + " false ))");
						ssa.setFormula(formula);
					}
					AttrSymVar asymvar = new AttrSymVar(ssa);
					attrList.add(expr, asymvar);
					return PROCESS_CONTINUE;
				} else {
					String sformula1 = symVarLeft.getSSAName();
					String sformula2 = symVarRight.getSSAName();
					String opsymbol = OpTranslator.binaryOp(binop);

					if (opsymbol != null) {
						if (opsymbol.equals("==")) {
							String formula = new String("( assert (= "
									+ ssa.getSSAName() + " (" + "=" + " "
									+ sformula1 + " " + sformula2 + " )))");
							ssa.setFormula(formula);
							// convert << to +
						} else if (opsymbol.equals("<<")) {

						} else if (opsymbol.equals("^")) {

						} else {
							String formula = new String("( assert (= "
									+ ssa.getSSAName() + " (" + opsymbol + " "
									+ sformula1 + " " + sformula2 + " )))");
							ssa.setFormula(formula);
						}
					}

					ssa.addDependency(symVarLeft);
					ssa.addDependency(symVarRight);

					AttrSymVar asymvar = new AttrSymVar(ssa);
					attrList.add(expr, asymvar);
				}
			}
		}

		if (expr instanceof IASTArraySubscriptExpression) {
			IASTArraySubscriptExpression subex = (IASTArraySubscriptExpression) expr;
			IASTExpression arrex = subex.getArrayExpression();
			IASTInitializerClause inicl = subex.getArgument();
			AttrSymVar asymvar1 = (AttrSymVar) attrList.getAttribute(inicl,
					"symvar");
			AttrSymVar asymvar2 = (AttrSymVar) attrList.getAttribute(arrex,
					"symvar");
			SymIntSSA si_ssa = (SymIntSSA) asymvar1.getSymVar();
			SymVarSSA tgarr = asymvar2.getSymVar();
			if (tgarr.getESymType() == eSymType.SymArray) {
				SymArraySSA arr_ssa = (SymArraySSA) asymvar2.getSymVar();
				SymPointerSSA spo_ssa = (SymPointerSSA) ps.declareLocal(
						eSymType.SymPointer, null);
				SymPointerOrig spo = (SymPointerOrig) spo_ssa.getOrig();
				eSymType targetType = eSymType.SymArray; // FIXME: check
				// target
				// type
				// write
				// through
				// to ssa ??
				spo.setTargetType(targetType);
				String sformula = new String("(assert (= "
						+ spo_ssa.getSSAName() + " " + si_ssa.getSSAName()
						+ " ))");
				spo_ssa.setFormula(sformula);
				SymArrayOrig arr_orig = (SymArrayOrig) ps
						.resolveOrigSymVar(arr_ssa.getOrigName());
				spo_ssa.setTarget(arr_orig);
				spo_ssa.addDependency(si_ssa);
				spo_ssa.addDependency(arr_ssa);
				AttrSymVar asymvar = new AttrSymVar(spo_ssa);
				attrList.add(expr, asymvar);
			} else if (asymvar2.getSymVar().getESymType() == eSymType.SymPointer) {
				SymPointerSSA pt_arr_ssa = (SymPointerSSA) asymvar2.getSymVar();
				SymPointerSSA spo_ssa = (SymPointerSSA) ps.declareLocal(
						eSymType.SymPointer, null);
				SymPointerOrig spo = (SymPointerOrig) spo_ssa.getOrig();
				eSymType targetType = eSymType.SymArray;
				spo.setTargetType(targetType);
				String sformula = new String("(assert (= "
						+ spo_ssa.getSSAName() + " " + si_ssa.getSSAName()
						+ " ))");
				spo_ssa.setFormula(sformula);
				SymArrayOrig arr_orig = (SymArrayOrig) pt_arr_ssa.getTarget();
				spo_ssa.setTarget(arr_orig);
				spo_ssa.addDependency(si_ssa);
				// spo_ssa.addDependency(pt_arr_ssa.getTargetSSA());
				if (pt_arr_ssa.hasTargetType) {
					spo_ssa.addDependency(pt_arr_ssa.getTargetSSA());
				}
				AttrSymVar asymvar = new AttrSymVar(spo_ssa);
				attrList.add(expr, asymvar);
			}
		}
		if (expr instanceof IASTCastExpression) {
			IASTCastExpression cexpr = (IASTCastExpression) expr;
			IASTExpression operand = cexpr.getOperand();
			AttrSymComposite asymcomposite1 = (AttrSymComposite) attrList
					.getAttribute(operand, "symcomposite");
			AttrSymVar asymvar1 = (AttrSymVar) attrList.getAttribute(operand,
					"symvar");
			if (asymvar1 == null) {
				attrList.add(expr, asymcomposite1);
				return PROCESS_CONTINUE;
			} else {
				SymVarSSA oldssa = asymvar1.getSymVar();
				eSymType eoldsymtype = oldssa.getESymType();
				IASTTypeId tid = cexpr.getTypeId();
				AttrSymType anewsymtype = (AttrSymType) attrList.getAttribute(
						tid, "symtype");
				if (anewsymtype == null) {
					attrList.add(expr, asymvar1);
					return PROCESS_CONTINUE;
				}

				SymVarOrig newsymtype = anewsymtype.getSymType();
				eSymType enewsymtype = newsymtype.getSymType();
				IName iname = newsymtype.getOrigName();
				if (eoldsymtype == enewsymtype) {
					attrList.add(expr, asymvar1);
				} else {
					// maybe cast and pass upwards; maybe set formula
					SymVarSSA ssaCopy;
					ssaCopy = ps.resolveOrigSymVar(iname).getCurrentSSACopy();
					if (enewsymtype == eSymType.SymPointer) {
						SymPointerSSA sps = (SymPointerSSA) ssaCopy;
						// TODO: check for null pointer, currently:
						// sympointer
						// to symint without target
						if ((eoldsymtype == eSymType.SymInt)
								&& (ps.getConcreteInt(oldssa) == 0)) {
							// assume null pointer
							if (ssaCopy == null) {
								ssaCopy = (SymVarSSA) ps.declareLocal(
										eSymType.SymPointer, null);
								AttrSymVar asymvar = new AttrSymVar(ssaCopy);
								attrList.add(expr, asymvar);
								return PROCESS_CONTINUE;
							}
						} else {
							sps.setTargetType(eoldsymtype);
							SymVarOrig oldOrig = ps.resolveOrigSymVar(oldssa
									.getOrigName());
							sps.setTarget(oldOrig);
						}
					}
					if (ps.isMTA()) {
						if (oldssa.getOrig().isShared()) {
							ssaCopy.getOrig().setShared();
						}
					}
					AttrSymVar asymvar = new AttrSymVar(ssaCopy);
					attrList.add(expr, asymvar);
				}

			}
		}
		if (expr instanceof IASTTypeIdExpression) {
			IASTTypeId typeid = ((IASTTypeIdExpression) expr).getTypeId();
			AttrSymType asymtype = (AttrSymType) attrList.getAttribute(typeid,
					"symtype");
			int op = ((IASTTypeIdExpression) expr).getOperator();
			SymVarOrig svo = asymtype.getSymType();
			switch (op) {
			case IASTTypeIdExpression.op_sizeof: {
				// TODO remove duplicate with
				// IASTUnaryExpression-typeof-operator; maybe move
				// both to
				// SymVar methods
				eSymType est = svo.getSymType();
				String ssize = null;
				switch (est) {
				case SymPointer:
				case SymBool:
				case SymInt: {
					ssize = "1";
					break;
				}
				}
				SymVarSSA ssa = svo.getCurrentSSACopy();
				ssa.setFormula(new String("(assert (= " + ssa.getSSAName()
						+ " " + ssize + " ))"));
				AttrSymVar asymvar = new AttrSymVar(ssa);
				attrList.add(expr, asymvar);
				break;
			}
			}
		}

		return PROCESS_CONTINUE;

	}

	@Override
	public ArrayList<IASTName> getFunctionNames() {
		return fcnames;
	}
}
