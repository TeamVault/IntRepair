package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AttributeDefinition_SpaceKeyword_1_1_a;
	protected AbstractElementAlias match_AttributeDefinition___Control000aKeyword_2_0_or_Control000dKeyword_2_1__a;
	protected AbstractElementAlias match_FunctionAnnotation_SpaceKeyword_1_0_2_q;
	protected AbstractElementAlias match_FunctionAnnotation_SpaceKeyword_1_1_4_q;
	protected AbstractElementAlias match_FunctionAnnotation_SpaceKeyword_1_2_3_q;
	protected AbstractElementAlias match_FunctionAnnotation_SpaceKeyword_1_3_3_q;
	protected AbstractElementAlias match_FunctionAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__q;
	protected AbstractElementAlias match_FunctionAnnotation___Control000aKeyword_1_1_8_0_or_Control000dKeyword_1_1_8_1__q;
	protected AbstractElementAlias match_FunctionAnnotation___Control000aKeyword_1_2_7_0_or_Control000dKeyword_1_2_7_1__q;
	protected AbstractElementAlias match_FunctionAnnotation___Control000aKeyword_1_3_7_0_or_Control000dKeyword_1_3_7_1__q;
	protected AbstractElementAlias match_IDSpace_SpaceKeyword_1_1_a;
	protected AbstractElementAlias match_KeyWord_ClassKeyword_1_19_or_DefineKeyword_1_7_or_ElifKeyword_1_16_or_ElseKeyword_1_15_or_EndifKeyword_1_20_or_ErrorKeyword_1_17_or_IfKeyword_1_11_or_IfdefKeyword_1_10_or_IfndefKeyword_1_8_or_IncludeKeyword_1_12_or_Include_nextKeyword_1_13_or_PragmaKeyword_1_14_or_SourceKeyword_1_21_or_TypedefKeyword_1_18_or_UndefKeyword_1_9_or___BEGIN_NAMESPACE_C99Keyword_1_2_or___BEGIN_NAMESPACE_STDKeyword_1_1_or___END_DECLSKeyword_1_3_or___END_NAMESPACE_C99Keyword_1_5_or___END_NAMESPACE_STDKeyword_1_4_or___USING_NAMESPACE_STDKeyword_1_6;
	protected AbstractElementAlias match_MethodHeader_IDTerminalRuleCall_1_1_1_q;
	protected AbstractElementAlias match_MethodHeader_IDTerminalRuleCall_1_1_3_q;
	protected AbstractElementAlias match_MethodHeader_IDTerminalRuleCall_1_1_5_q;
	protected AbstractElementAlias match_MethodHeader___Control000aKeyword_2_0_or_Control000dKeyword_2_1__q;
	protected AbstractElementAlias match_MethodHeader___SpaceKeyword_1_0_1_0_q_AsteriskKeyword_1_0_1_1_a_SpaceKeyword_1_0_1_2_a_IDTerminalRuleCall_1_0_1_3_SpaceKeyword_1_0_1_4_q__a;
	protected AbstractElementAlias match_MultilineAnnotation_AsteriskSpaceKeyword_1_0_1_q;
	protected AbstractElementAlias match_MultilineAnnotation_Control000aKeyword_1_0_3_q;
	protected AbstractElementAlias match_MultilineAnnotation_SpaceCommercialAtAsteriskSolidusKeyword_1_0_4_q;
	protected AbstractElementAlias match_MultilineAnnotation___Control000aKeyword_1_1_5_0_or_Control000dKeyword_1_1_5_1__q;
	protected AbstractElementAlias match_SYMBOLS_AmpersandKeyword_1_33_or_AsteriskKeyword_1_7_or_AsteriskSpaceKeyword_1_8_or_BackSlashParserRuleCall_1_22_or_CURLY_CLOSETerminalRuleCall_1_37_or_CURLY_OPENTerminalRuleCall_1_36_or_CircumflexAccentKeyword_1_18_or_ColonKeyword_1_32_or_Control000aKeyword_1_11_or_Control000cKeyword_1_4_or_DoubleQuoteParserRuleCall_1_30_or_EqualsSignKeyword_1_27_or_ExclamationMarkKeyword_1_29_or_FullStopFullStopFullStopKeyword_1_3_or_FullStopFullStopKeyword_1_2_or_FullStopKeyword_1_1_or_GreaterThanSignGreaterThanSignKeyword_1_14_or_GreaterThanSignKeyword_1_16_or_HyphenMinusGreaterThanSignKeyword_1_25_or_HyphenMinusKeyword_1_20_or_INTTerminalRuleCall_1_38_or_LeftParenthesisKeyword_1_12_or_LeftSquareBracketKeyword_1_9_or_LessThanSignHyphenMinusKeyword_1_26_or_LessThanSignKeyword_1_17_or_LessThanSignLessThanSignKeyword_1_15_or_NumberSignKeyword_1_35_or_PercentSignKeyword_1_23_or_PlusSignKeyword_1_19_or_QuestionMarkKeyword_1_28_or_RightParenthesisKeyword_1_13_or_RightSquareBracketKeyword_1_10_or_SemicolonKeyword_1_5_or_SingleQuoteParserRuleCall_1_31_or_SolidusKeyword_1_21_or_SpaceKeyword_1_6_or_TildeKeyword_1_34_or_VerticalLineKeyword_1_24;
	protected AbstractElementAlias match_SingleLineAnnotation_SpaceKeyword_1_0_2_q;
	protected AbstractElementAlias match_SingleLineAnnotation_SpaceKeyword_1_1_3_q;
	protected AbstractElementAlias match_SingleLineAnnotation_SpaceKeyword_1_2_3_q;
	protected AbstractElementAlias match_SingleLineAnnotation_SpaceKeyword_1_3_2_q;
	protected AbstractElementAlias match_SingleLineAnnotation_SpaceKeyword_1_4_2_q;
	protected AbstractElementAlias match_SingleLineAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__a;
	protected AbstractElementAlias match_SingleLineAnnotation___Control000aKeyword_1_1_6_0_or_Control000dKeyword_1_1_6_1__q;
	protected AbstractElementAlias match_SingleLineAnnotation___Control000aKeyword_1_2_6_0_or_Control000dKeyword_1_2_6_1__q;
	protected AbstractElementAlias match_SingleLineAnnotation___Control000aKeyword_1_3_6_0_or_Control000dKeyword_1_3_6_1__a;
	protected AbstractElementAlias match_SingleLineAnnotation___Control000aKeyword_1_4_6_0_or_Control000dKeyword_1_4_6_1__a;
	protected AbstractElementAlias match_SpaceID_IDTerminalRuleCall_1_1_a;
	protected AbstractElementAlias match_SpecialExpression_IDTerminalRuleCall_1_1_2_q;
	protected AbstractElementAlias match_SpecialExpression_IDTerminalRuleCall_1_2_4_q;
	protected AbstractElementAlias match_SpecialExpression_INTTerminalRuleCall_1_3_or___AsteriskAsteriskKeyword_1_1_0_IDTerminalRuleCall_1_1_2_q__;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyDslGrammarAccess) access;
		match_AttributeDefinition_SpaceKeyword_1_1_a = new TokenAlias(true, true, grammarAccess.getAttributeDefinitionAccess().getSpaceKeyword_1_1());
		match_AttributeDefinition___Control000aKeyword_2_0_or_Control000dKeyword_2_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getAttributeDefinitionAccess().getControl000aKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getAttributeDefinitionAccess().getControl000dKeyword_2_1()));
		match_FunctionAnnotation_SpaceKeyword_1_0_2_q = new TokenAlias(false, true, grammarAccess.getFunctionAnnotationAccess().getSpaceKeyword_1_0_2());
		match_FunctionAnnotation_SpaceKeyword_1_1_4_q = new TokenAlias(false, true, grammarAccess.getFunctionAnnotationAccess().getSpaceKeyword_1_1_4());
		match_FunctionAnnotation_SpaceKeyword_1_2_3_q = new TokenAlias(false, true, grammarAccess.getFunctionAnnotationAccess().getSpaceKeyword_1_2_3());
		match_FunctionAnnotation_SpaceKeyword_1_3_3_q = new TokenAlias(false, true, grammarAccess.getFunctionAnnotationAccess().getSpaceKeyword_1_3_3());
		match_FunctionAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000aKeyword_1_0_6_0()), new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000dKeyword_1_0_6_1()));
		match_FunctionAnnotation___Control000aKeyword_1_1_8_0_or_Control000dKeyword_1_1_8_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000aKeyword_1_1_8_0()), new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000dKeyword_1_1_8_1()));
		match_FunctionAnnotation___Control000aKeyword_1_2_7_0_or_Control000dKeyword_1_2_7_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000aKeyword_1_2_7_0()), new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000dKeyword_1_2_7_1()));
		match_FunctionAnnotation___Control000aKeyword_1_3_7_0_or_Control000dKeyword_1_3_7_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000aKeyword_1_3_7_0()), new TokenAlias(false, false, grammarAccess.getFunctionAnnotationAccess().getControl000dKeyword_1_3_7_1()));
		match_IDSpace_SpaceKeyword_1_1_a = new TokenAlias(true, true, grammarAccess.getIDSpaceAccess().getSpaceKeyword_1_1());
		match_KeyWord_ClassKeyword_1_19_or_DefineKeyword_1_7_or_ElifKeyword_1_16_or_ElseKeyword_1_15_or_EndifKeyword_1_20_or_ErrorKeyword_1_17_or_IfKeyword_1_11_or_IfdefKeyword_1_10_or_IfndefKeyword_1_8_or_IncludeKeyword_1_12_or_Include_nextKeyword_1_13_or_PragmaKeyword_1_14_or_SourceKeyword_1_21_or_TypedefKeyword_1_18_or_UndefKeyword_1_9_or___BEGIN_NAMESPACE_C99Keyword_1_2_or___BEGIN_NAMESPACE_STDKeyword_1_1_or___END_DECLSKeyword_1_3_or___END_NAMESPACE_C99Keyword_1_5_or___END_NAMESPACE_STDKeyword_1_4_or___USING_NAMESPACE_STDKeyword_1_6 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getClassKeyword_1_19()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getDefineKeyword_1_7()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getElifKeyword_1_16()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getElseKeyword_1_15()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getEndifKeyword_1_20()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getErrorKeyword_1_17()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getIfKeyword_1_11()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getIfdefKeyword_1_10()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getIfndefKeyword_1_8()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getIncludeKeyword_1_12()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getInclude_nextKeyword_1_13()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getPragmaKeyword_1_14()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getSourceKeyword_1_21()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getTypedefKeyword_1_18()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().getUndefKeyword_1_9()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__BEGIN_NAMESPACE_C99Keyword_1_2()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__BEGIN_NAMESPACE_STDKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__END_DECLSKeyword_1_3()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__END_NAMESPACE_C99Keyword_1_5()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__END_NAMESPACE_STDKeyword_1_4()), new TokenAlias(false, false, grammarAccess.getKeyWordAccess().get__USING_NAMESPACE_STDKeyword_1_6()));
		match_MethodHeader_IDTerminalRuleCall_1_1_1_q = new TokenAlias(false, true, grammarAccess.getMethodHeaderAccess().getIDTerminalRuleCall_1_1_1());
		match_MethodHeader_IDTerminalRuleCall_1_1_3_q = new TokenAlias(false, true, grammarAccess.getMethodHeaderAccess().getIDTerminalRuleCall_1_1_3());
		match_MethodHeader_IDTerminalRuleCall_1_1_5_q = new TokenAlias(false, true, grammarAccess.getMethodHeaderAccess().getIDTerminalRuleCall_1_1_5());
		match_MethodHeader___Control000aKeyword_2_0_or_Control000dKeyword_2_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getMethodHeaderAccess().getControl000aKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getMethodHeaderAccess().getControl000dKeyword_2_1()));
		match_MethodHeader___SpaceKeyword_1_0_1_0_q_AsteriskKeyword_1_0_1_1_a_SpaceKeyword_1_0_1_2_a_IDTerminalRuleCall_1_0_1_3_SpaceKeyword_1_0_1_4_q__a = new GroupAlias(true, true, new TokenAlias(false, true, grammarAccess.getMethodHeaderAccess().getSpaceKeyword_1_0_1_0()), new TokenAlias(true, true, grammarAccess.getMethodHeaderAccess().getAsteriskKeyword_1_0_1_1()), new TokenAlias(true, true, grammarAccess.getMethodHeaderAccess().getSpaceKeyword_1_0_1_2()), new TokenAlias(false, false, grammarAccess.getMethodHeaderAccess().getIDTerminalRuleCall_1_0_1_3()), new TokenAlias(false, true, grammarAccess.getMethodHeaderAccess().getSpaceKeyword_1_0_1_4()));
		match_MultilineAnnotation_AsteriskSpaceKeyword_1_0_1_q = new TokenAlias(false, true, grammarAccess.getMultilineAnnotationAccess().getAsteriskSpaceKeyword_1_0_1());
		match_MultilineAnnotation_Control000aKeyword_1_0_3_q = new TokenAlias(false, true, grammarAccess.getMultilineAnnotationAccess().getControl000aKeyword_1_0_3());
		match_MultilineAnnotation_SpaceCommercialAtAsteriskSolidusKeyword_1_0_4_q = new TokenAlias(false, true, grammarAccess.getMultilineAnnotationAccess().getSpaceCommercialAtAsteriskSolidusKeyword_1_0_4());
		match_MultilineAnnotation___Control000aKeyword_1_1_5_0_or_Control000dKeyword_1_1_5_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getMultilineAnnotationAccess().getControl000aKeyword_1_1_5_0()), new TokenAlias(false, false, grammarAccess.getMultilineAnnotationAccess().getControl000dKeyword_1_1_5_1()));
		match_SYMBOLS_AmpersandKeyword_1_33_or_AsteriskKeyword_1_7_or_AsteriskSpaceKeyword_1_8_or_BackSlashParserRuleCall_1_22_or_CURLY_CLOSETerminalRuleCall_1_37_or_CURLY_OPENTerminalRuleCall_1_36_or_CircumflexAccentKeyword_1_18_or_ColonKeyword_1_32_or_Control000aKeyword_1_11_or_Control000cKeyword_1_4_or_DoubleQuoteParserRuleCall_1_30_or_EqualsSignKeyword_1_27_or_ExclamationMarkKeyword_1_29_or_FullStopFullStopFullStopKeyword_1_3_or_FullStopFullStopKeyword_1_2_or_FullStopKeyword_1_1_or_GreaterThanSignGreaterThanSignKeyword_1_14_or_GreaterThanSignKeyword_1_16_or_HyphenMinusGreaterThanSignKeyword_1_25_or_HyphenMinusKeyword_1_20_or_INTTerminalRuleCall_1_38_or_LeftParenthesisKeyword_1_12_or_LeftSquareBracketKeyword_1_9_or_LessThanSignHyphenMinusKeyword_1_26_or_LessThanSignKeyword_1_17_or_LessThanSignLessThanSignKeyword_1_15_or_NumberSignKeyword_1_35_or_PercentSignKeyword_1_23_or_PlusSignKeyword_1_19_or_QuestionMarkKeyword_1_28_or_RightParenthesisKeyword_1_13_or_RightSquareBracketKeyword_1_10_or_SemicolonKeyword_1_5_or_SingleQuoteParserRuleCall_1_31_or_SolidusKeyword_1_21_or_SpaceKeyword_1_6_or_TildeKeyword_1_34_or_VerticalLineKeyword_1_24 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getAmpersandKeyword_1_33()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getAsteriskKeyword_1_7()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getAsteriskSpaceKeyword_1_8()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getBackSlashParserRuleCall_1_22()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getCURLY_CLOSETerminalRuleCall_1_37()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getCURLY_OPENTerminalRuleCall_1_36()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getCircumflexAccentKeyword_1_18()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getColonKeyword_1_32()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getControl000aKeyword_1_11()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getControl000cKeyword_1_4()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getDoubleQuoteParserRuleCall_1_30()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getEqualsSignKeyword_1_27()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getExclamationMarkKeyword_1_29()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getFullStopFullStopFullStopKeyword_1_3()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getFullStopFullStopKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getFullStopKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getGreaterThanSignGreaterThanSignKeyword_1_14()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getGreaterThanSignKeyword_1_16()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getHyphenMinusGreaterThanSignKeyword_1_25()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getHyphenMinusKeyword_1_20()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getINTTerminalRuleCall_1_38()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getLeftParenthesisKeyword_1_12()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getLeftSquareBracketKeyword_1_9()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getLessThanSignHyphenMinusKeyword_1_26()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getLessThanSignKeyword_1_17()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getLessThanSignLessThanSignKeyword_1_15()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getNumberSignKeyword_1_35()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getPercentSignKeyword_1_23()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getPlusSignKeyword_1_19()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getQuestionMarkKeyword_1_28()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getRightParenthesisKeyword_1_13()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getRightSquareBracketKeyword_1_10()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getSemicolonKeyword_1_5()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getSingleQuoteParserRuleCall_1_31()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getSolidusKeyword_1_21()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getSpaceKeyword_1_6()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getTildeKeyword_1_34()), new TokenAlias(false, false, grammarAccess.getSYMBOLSAccess().getVerticalLineKeyword_1_24()));
		match_SingleLineAnnotation_SpaceKeyword_1_0_2_q = new TokenAlias(false, true, grammarAccess.getSingleLineAnnotationAccess().getSpaceKeyword_1_0_2());
		match_SingleLineAnnotation_SpaceKeyword_1_1_3_q = new TokenAlias(false, true, grammarAccess.getSingleLineAnnotationAccess().getSpaceKeyword_1_1_3());
		match_SingleLineAnnotation_SpaceKeyword_1_2_3_q = new TokenAlias(false, true, grammarAccess.getSingleLineAnnotationAccess().getSpaceKeyword_1_2_3());
		match_SingleLineAnnotation_SpaceKeyword_1_3_2_q = new TokenAlias(false, true, grammarAccess.getSingleLineAnnotationAccess().getSpaceKeyword_1_3_2());
		match_SingleLineAnnotation_SpaceKeyword_1_4_2_q = new TokenAlias(false, true, grammarAccess.getSingleLineAnnotationAccess().getSpaceKeyword_1_4_2());
		match_SingleLineAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000aKeyword_1_0_6_0()), new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000dKeyword_1_0_6_1()));
		match_SingleLineAnnotation___Control000aKeyword_1_1_6_0_or_Control000dKeyword_1_1_6_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000aKeyword_1_1_6_0()), new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000dKeyword_1_1_6_1()));
		match_SingleLineAnnotation___Control000aKeyword_1_2_6_0_or_Control000dKeyword_1_2_6_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000aKeyword_1_2_6_0()), new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000dKeyword_1_2_6_1()));
		match_SingleLineAnnotation___Control000aKeyword_1_3_6_0_or_Control000dKeyword_1_3_6_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000aKeyword_1_3_6_0()), new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000dKeyword_1_3_6_1()));
		match_SingleLineAnnotation___Control000aKeyword_1_4_6_0_or_Control000dKeyword_1_4_6_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000aKeyword_1_4_6_0()), new TokenAlias(false, false, grammarAccess.getSingleLineAnnotationAccess().getControl000dKeyword_1_4_6_1()));
		match_SpaceID_IDTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getSpaceIDAccess().getIDTerminalRuleCall_1_1());
		match_SpecialExpression_IDTerminalRuleCall_1_1_2_q = new TokenAlias(false, true, grammarAccess.getSpecialExpressionAccess().getIDTerminalRuleCall_1_1_2());
		match_SpecialExpression_IDTerminalRuleCall_1_2_4_q = new TokenAlias(false, true, grammarAccess.getSpecialExpressionAccess().getIDTerminalRuleCall_1_2_4());
		match_SpecialExpression_INTTerminalRuleCall_1_3_or___AsteriskAsteriskKeyword_1_1_0_IDTerminalRuleCall_1_1_2_q__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getSpecialExpressionAccess().getAsteriskAsteriskKeyword_1_1_0()), new TokenAlias(false, true, grammarAccess.getSpecialExpressionAccess().getIDTerminalRuleCall_1_1_2())), new TokenAlias(false, false, grammarAccess.getSpecialExpressionAccess().getINTTerminalRuleCall_1_3()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getBackSlashRule())
			return getBackSlashToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCURLY_CLOSERule())
			return getCURLY_CLOSEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCURLY_OPENRule())
			return getCURLY_OPENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDoubleQuoteRule())
			return getDoubleQuoteToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSingleQuoteRule())
			return getSingleQuoteToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * BackSlash:
	 *  	STRING | MY_BACKSLASH
	 *  ;
	 */
	protected String getBackSlashToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	/**
	 * terminal CURLY_CLOSE:  '}';
	 */
	protected String getCURLY_CLOSEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "}";
	}
	
	/**
	 * terminal CURLY_OPEN:   '{';
	 */
	protected String getCURLY_OPENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "{";
	}
	
	/**
	 * DoubleQuote: 
	 *  	STRING | DOUBLE_DQ_STRING
	 *  ;
	 */
	protected String getDoubleQuoteToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	/**
	 * terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal INT returns ecore::EInt: ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * SingleQuote: 
	 *  	 MY_STRING
	 *  ;
	 */
	protected String getSingleQuoteToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AttributeDefinition_SpaceKeyword_1_1_a.equals(syntax))
				emit_AttributeDefinition_SpaceKeyword_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AttributeDefinition___Control000aKeyword_2_0_or_Control000dKeyword_2_1__a.equals(syntax))
				emit_AttributeDefinition___Control000aKeyword_2_0_or_Control000dKeyword_2_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation_SpaceKeyword_1_0_2_q.equals(syntax))
				emit_FunctionAnnotation_SpaceKeyword_1_0_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation_SpaceKeyword_1_1_4_q.equals(syntax))
				emit_FunctionAnnotation_SpaceKeyword_1_1_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation_SpaceKeyword_1_2_3_q.equals(syntax))
				emit_FunctionAnnotation_SpaceKeyword_1_2_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation_SpaceKeyword_1_3_3_q.equals(syntax))
				emit_FunctionAnnotation_SpaceKeyword_1_3_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__q.equals(syntax))
				emit_FunctionAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation___Control000aKeyword_1_1_8_0_or_Control000dKeyword_1_1_8_1__q.equals(syntax))
				emit_FunctionAnnotation___Control000aKeyword_1_1_8_0_or_Control000dKeyword_1_1_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation___Control000aKeyword_1_2_7_0_or_Control000dKeyword_1_2_7_1__q.equals(syntax))
				emit_FunctionAnnotation___Control000aKeyword_1_2_7_0_or_Control000dKeyword_1_2_7_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionAnnotation___Control000aKeyword_1_3_7_0_or_Control000dKeyword_1_3_7_1__q.equals(syntax))
				emit_FunctionAnnotation___Control000aKeyword_1_3_7_0_or_Control000dKeyword_1_3_7_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IDSpace_SpaceKeyword_1_1_a.equals(syntax))
				emit_IDSpace_SpaceKeyword_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_KeyWord_ClassKeyword_1_19_or_DefineKeyword_1_7_or_ElifKeyword_1_16_or_ElseKeyword_1_15_or_EndifKeyword_1_20_or_ErrorKeyword_1_17_or_IfKeyword_1_11_or_IfdefKeyword_1_10_or_IfndefKeyword_1_8_or_IncludeKeyword_1_12_or_Include_nextKeyword_1_13_or_PragmaKeyword_1_14_or_SourceKeyword_1_21_or_TypedefKeyword_1_18_or_UndefKeyword_1_9_or___BEGIN_NAMESPACE_C99Keyword_1_2_or___BEGIN_NAMESPACE_STDKeyword_1_1_or___END_DECLSKeyword_1_3_or___END_NAMESPACE_C99Keyword_1_5_or___END_NAMESPACE_STDKeyword_1_4_or___USING_NAMESPACE_STDKeyword_1_6.equals(syntax))
				emit_KeyWord_ClassKeyword_1_19_or_DefineKeyword_1_7_or_ElifKeyword_1_16_or_ElseKeyword_1_15_or_EndifKeyword_1_20_or_ErrorKeyword_1_17_or_IfKeyword_1_11_or_IfdefKeyword_1_10_or_IfndefKeyword_1_8_or_IncludeKeyword_1_12_or_Include_nextKeyword_1_13_or_PragmaKeyword_1_14_or_SourceKeyword_1_21_or_TypedefKeyword_1_18_or_UndefKeyword_1_9_or___BEGIN_NAMESPACE_C99Keyword_1_2_or___BEGIN_NAMESPACE_STDKeyword_1_1_or___END_DECLSKeyword_1_3_or___END_NAMESPACE_C99Keyword_1_5_or___END_NAMESPACE_STDKeyword_1_4_or___USING_NAMESPACE_STDKeyword_1_6(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MethodHeader_IDTerminalRuleCall_1_1_1_q.equals(syntax))
				emit_MethodHeader_IDTerminalRuleCall_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MethodHeader_IDTerminalRuleCall_1_1_3_q.equals(syntax))
				emit_MethodHeader_IDTerminalRuleCall_1_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MethodHeader_IDTerminalRuleCall_1_1_5_q.equals(syntax))
				emit_MethodHeader_IDTerminalRuleCall_1_1_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MethodHeader___Control000aKeyword_2_0_or_Control000dKeyword_2_1__q.equals(syntax))
				emit_MethodHeader___Control000aKeyword_2_0_or_Control000dKeyword_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MethodHeader___SpaceKeyword_1_0_1_0_q_AsteriskKeyword_1_0_1_1_a_SpaceKeyword_1_0_1_2_a_IDTerminalRuleCall_1_0_1_3_SpaceKeyword_1_0_1_4_q__a.equals(syntax))
				emit_MethodHeader___SpaceKeyword_1_0_1_0_q_AsteriskKeyword_1_0_1_1_a_SpaceKeyword_1_0_1_2_a_IDTerminalRuleCall_1_0_1_3_SpaceKeyword_1_0_1_4_q__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MultilineAnnotation_AsteriskSpaceKeyword_1_0_1_q.equals(syntax))
				emit_MultilineAnnotation_AsteriskSpaceKeyword_1_0_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MultilineAnnotation_Control000aKeyword_1_0_3_q.equals(syntax))
				emit_MultilineAnnotation_Control000aKeyword_1_0_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MultilineAnnotation_SpaceCommercialAtAsteriskSolidusKeyword_1_0_4_q.equals(syntax))
				emit_MultilineAnnotation_SpaceCommercialAtAsteriskSolidusKeyword_1_0_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MultilineAnnotation___Control000aKeyword_1_1_5_0_or_Control000dKeyword_1_1_5_1__q.equals(syntax))
				emit_MultilineAnnotation___Control000aKeyword_1_1_5_0_or_Control000dKeyword_1_1_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SYMBOLS_AmpersandKeyword_1_33_or_AsteriskKeyword_1_7_or_AsteriskSpaceKeyword_1_8_or_BackSlashParserRuleCall_1_22_or_CURLY_CLOSETerminalRuleCall_1_37_or_CURLY_OPENTerminalRuleCall_1_36_or_CircumflexAccentKeyword_1_18_or_ColonKeyword_1_32_or_Control000aKeyword_1_11_or_Control000cKeyword_1_4_or_DoubleQuoteParserRuleCall_1_30_or_EqualsSignKeyword_1_27_or_ExclamationMarkKeyword_1_29_or_FullStopFullStopFullStopKeyword_1_3_or_FullStopFullStopKeyword_1_2_or_FullStopKeyword_1_1_or_GreaterThanSignGreaterThanSignKeyword_1_14_or_GreaterThanSignKeyword_1_16_or_HyphenMinusGreaterThanSignKeyword_1_25_or_HyphenMinusKeyword_1_20_or_INTTerminalRuleCall_1_38_or_LeftParenthesisKeyword_1_12_or_LeftSquareBracketKeyword_1_9_or_LessThanSignHyphenMinusKeyword_1_26_or_LessThanSignKeyword_1_17_or_LessThanSignLessThanSignKeyword_1_15_or_NumberSignKeyword_1_35_or_PercentSignKeyword_1_23_or_PlusSignKeyword_1_19_or_QuestionMarkKeyword_1_28_or_RightParenthesisKeyword_1_13_or_RightSquareBracketKeyword_1_10_or_SemicolonKeyword_1_5_or_SingleQuoteParserRuleCall_1_31_or_SolidusKeyword_1_21_or_SpaceKeyword_1_6_or_TildeKeyword_1_34_or_VerticalLineKeyword_1_24.equals(syntax))
				emit_SYMBOLS_AmpersandKeyword_1_33_or_AsteriskKeyword_1_7_or_AsteriskSpaceKeyword_1_8_or_BackSlashParserRuleCall_1_22_or_CURLY_CLOSETerminalRuleCall_1_37_or_CURLY_OPENTerminalRuleCall_1_36_or_CircumflexAccentKeyword_1_18_or_ColonKeyword_1_32_or_Control000aKeyword_1_11_or_Control000cKeyword_1_4_or_DoubleQuoteParserRuleCall_1_30_or_EqualsSignKeyword_1_27_or_ExclamationMarkKeyword_1_29_or_FullStopFullStopFullStopKeyword_1_3_or_FullStopFullStopKeyword_1_2_or_FullStopKeyword_1_1_or_GreaterThanSignGreaterThanSignKeyword_1_14_or_GreaterThanSignKeyword_1_16_or_HyphenMinusGreaterThanSignKeyword_1_25_or_HyphenMinusKeyword_1_20_or_INTTerminalRuleCall_1_38_or_LeftParenthesisKeyword_1_12_or_LeftSquareBracketKeyword_1_9_or_LessThanSignHyphenMinusKeyword_1_26_or_LessThanSignKeyword_1_17_or_LessThanSignLessThanSignKeyword_1_15_or_NumberSignKeyword_1_35_or_PercentSignKeyword_1_23_or_PlusSignKeyword_1_19_or_QuestionMarkKeyword_1_28_or_RightParenthesisKeyword_1_13_or_RightSquareBracketKeyword_1_10_or_SemicolonKeyword_1_5_or_SingleQuoteParserRuleCall_1_31_or_SolidusKeyword_1_21_or_SpaceKeyword_1_6_or_TildeKeyword_1_34_or_VerticalLineKeyword_1_24(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation_SpaceKeyword_1_0_2_q.equals(syntax))
				emit_SingleLineAnnotation_SpaceKeyword_1_0_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation_SpaceKeyword_1_1_3_q.equals(syntax))
				emit_SingleLineAnnotation_SpaceKeyword_1_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation_SpaceKeyword_1_2_3_q.equals(syntax))
				emit_SingleLineAnnotation_SpaceKeyword_1_2_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation_SpaceKeyword_1_3_2_q.equals(syntax))
				emit_SingleLineAnnotation_SpaceKeyword_1_3_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation_SpaceKeyword_1_4_2_q.equals(syntax))
				emit_SingleLineAnnotation_SpaceKeyword_1_4_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__a.equals(syntax))
				emit_SingleLineAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation___Control000aKeyword_1_1_6_0_or_Control000dKeyword_1_1_6_1__q.equals(syntax))
				emit_SingleLineAnnotation___Control000aKeyword_1_1_6_0_or_Control000dKeyword_1_1_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation___Control000aKeyword_1_2_6_0_or_Control000dKeyword_1_2_6_1__q.equals(syntax))
				emit_SingleLineAnnotation___Control000aKeyword_1_2_6_0_or_Control000dKeyword_1_2_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation___Control000aKeyword_1_3_6_0_or_Control000dKeyword_1_3_6_1__a.equals(syntax))
				emit_SingleLineAnnotation___Control000aKeyword_1_3_6_0_or_Control000dKeyword_1_3_6_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SingleLineAnnotation___Control000aKeyword_1_4_6_0_or_Control000dKeyword_1_4_6_1__a.equals(syntax))
				emit_SingleLineAnnotation___Control000aKeyword_1_4_6_0_or_Control000dKeyword_1_4_6_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SpaceID_IDTerminalRuleCall_1_1_a.equals(syntax))
				emit_SpaceID_IDTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SpecialExpression_IDTerminalRuleCall_1_1_2_q.equals(syntax))
				emit_SpecialExpression_IDTerminalRuleCall_1_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SpecialExpression_IDTerminalRuleCall_1_2_4_q.equals(syntax))
				emit_SpecialExpression_IDTerminalRuleCall_1_2_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SpecialExpression_INTTerminalRuleCall_1_3_or___AsteriskAsteriskKeyword_1_1_0_IDTerminalRuleCall_1_1_2_q__.equals(syntax))
				emit_SpecialExpression_INTTerminalRuleCall_1_3_or___AsteriskAsteriskKeyword_1_1_0_IDTerminalRuleCall_1_1_2_q__(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ' '*
	 */
	protected void emit_AttributeDefinition_SpaceKeyword_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	     ' | 
	     '
	 '
	 )*
	 */
	protected void emit_AttributeDefinition___Control000aKeyword_2_0_or_Control000dKeyword_2_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_FunctionAnnotation_SpaceKeyword_1_0_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_FunctionAnnotation_SpaceKeyword_1_1_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_FunctionAnnotation_SpaceKeyword_1_2_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_FunctionAnnotation_SpaceKeyword_1_3_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )?
	 */
	protected void emit_FunctionAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )?
	 */
	protected void emit_FunctionAnnotation___Control000aKeyword_1_1_8_0_or_Control000dKeyword_1_1_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )?
	 */
	protected void emit_FunctionAnnotation___Control000aKeyword_1_2_7_0_or_Control000dKeyword_1_2_7_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	     ' | 
	     '
	 '
	 )?
	 */
	protected void emit_FunctionAnnotation___Control000aKeyword_1_3_7_0_or_Control000dKeyword_1_3_7_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '*
	 */
	protected void emit_IDSpace_SpaceKeyword_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'else' | 
	     'pragma' | 
	     '__USING_NAMESPACE_STD' | 
	     'undef' | 
	     '__BEGIN_NAMESPACE_STD' | 
	     'ifdef' | 
	     'endif' | 
	     'error' | 
	     'ifndef' | 
	     '__BEGIN_NAMESPACE_C99' | 
	     'class' | 
	     'if' | 
	     'include' | 
	     'include_next' | 
	     'source' | 
	     '__END_NAMESPACE_C99' | 
	     'typedef' | 
	     'elif' | 
	     '__END_DECLS' | 
	     '__END_NAMESPACE_STD' | 
	     'define'
	 )
	 */
	protected void emit_KeyWord_ClassKeyword_1_19_or_DefineKeyword_1_7_or_ElifKeyword_1_16_or_ElseKeyword_1_15_or_EndifKeyword_1_20_or_ErrorKeyword_1_17_or_IfKeyword_1_11_or_IfdefKeyword_1_10_or_IfndefKeyword_1_8_or_IncludeKeyword_1_12_or_Include_nextKeyword_1_13_or_PragmaKeyword_1_14_or_SourceKeyword_1_21_or_TypedefKeyword_1_18_or_UndefKeyword_1_9_or___BEGIN_NAMESPACE_C99Keyword_1_2_or___BEGIN_NAMESPACE_STDKeyword_1_1_or___END_DECLSKeyword_1_3_or___END_NAMESPACE_C99Keyword_1_5_or___END_NAMESPACE_STDKeyword_1_4_or___USING_NAMESPACE_STDKeyword_1_6(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID?
	 */
	protected void emit_MethodHeader_IDTerminalRuleCall_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID?
	 */
	protected void emit_MethodHeader_IDTerminalRuleCall_1_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID?
	 */
	protected void emit_MethodHeader_IDTerminalRuleCall_1_1_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	     ' | 
	     '
	 '
	 )?
	 */
	protected void emit_MethodHeader___Control000aKeyword_2_0_or_Control000dKeyword_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (' '? '*'* ' '* ID ' '?)*
	 */
	protected void emit_MethodHeader___SpaceKeyword_1_0_1_0_q_AsteriskKeyword_1_0_1_1_a_SpaceKeyword_1_0_1_2_a_IDTerminalRuleCall_1_0_1_3_SpaceKeyword_1_0_1_4_q__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '* '?
	 */
	protected void emit_MultilineAnnotation_AsteriskSpaceKeyword_1_0_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '
	 '?
	 */
	protected void emit_MultilineAnnotation_Control000aKeyword_1_0_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *
	 */
	protected void emit_MultilineAnnotation_SpaceCommercialAtAsteriskSolidusKeyword_1_0_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	     ' | 
	     '
	 '
	 )?
	 */
	protected void emit_MultilineAnnotation___Control000aKeyword_1_1_5_0_or_Control000dKeyword_1_1_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '>' | 
	     '
	     ' | 
	     DoubleQuote | 
	     CURLY_OPEN | 
	     '*' | 
	     '-' | 
	     '&' | 
	     '>>' | 
	     '~' | 
	     '+' | 
	     '' | 
	     CURLY_CLOSE | 
	     '=' | 
	     '...' | 
	     '<-' | 
	     '?' | 
	     '..' | 
	     '%' | 
	     INT | 
	     '[' | 
	     ':' | 
	     BackSlash | 
	     '.' | 
	     '|' | 
	     SingleQuote | 
	     '#' | 
	     '<<' | 
	     ' ' | 
	     '<' | 
	     ';' | 
	     ')' | 
	     '(' | 
	     '^' | 
	     '!' | 
	     ']' | 
	     '/' | 
	     '->' | 
	     '* '
	 )
	 */
	protected void emit_SYMBOLS_AmpersandKeyword_1_33_or_AsteriskKeyword_1_7_or_AsteriskSpaceKeyword_1_8_or_BackSlashParserRuleCall_1_22_or_CURLY_CLOSETerminalRuleCall_1_37_or_CURLY_OPENTerminalRuleCall_1_36_or_CircumflexAccentKeyword_1_18_or_ColonKeyword_1_32_or_Control000aKeyword_1_11_or_Control000cKeyword_1_4_or_DoubleQuoteParserRuleCall_1_30_or_EqualsSignKeyword_1_27_or_ExclamationMarkKeyword_1_29_or_FullStopFullStopFullStopKeyword_1_3_or_FullStopFullStopKeyword_1_2_or_FullStopKeyword_1_1_or_GreaterThanSignGreaterThanSignKeyword_1_14_or_GreaterThanSignKeyword_1_16_or_HyphenMinusGreaterThanSignKeyword_1_25_or_HyphenMinusKeyword_1_20_or_INTTerminalRuleCall_1_38_or_LeftParenthesisKeyword_1_12_or_LeftSquareBracketKeyword_1_9_or_LessThanSignHyphenMinusKeyword_1_26_or_LessThanSignKeyword_1_17_or_LessThanSignLessThanSignKeyword_1_15_or_NumberSignKeyword_1_35_or_PercentSignKeyword_1_23_or_PlusSignKeyword_1_19_or_QuestionMarkKeyword_1_28_or_RightParenthesisKeyword_1_13_or_RightSquareBracketKeyword_1_10_or_SemicolonKeyword_1_5_or_SingleQuoteParserRuleCall_1_31_or_SolidusKeyword_1_21_or_SpaceKeyword_1_6_or_TildeKeyword_1_34_or_VerticalLineKeyword_1_24(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_SingleLineAnnotation_SpaceKeyword_1_0_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_SingleLineAnnotation_SpaceKeyword_1_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_SingleLineAnnotation_SpaceKeyword_1_2_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_SingleLineAnnotation_SpaceKeyword_1_3_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ' '?
	 */
	protected void emit_SingleLineAnnotation_SpaceKeyword_1_4_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )*
	 */
	protected void emit_SingleLineAnnotation___Control000aKeyword_1_0_6_0_or_Control000dKeyword_1_0_6_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )?
	 */
	protected void emit_SingleLineAnnotation___Control000aKeyword_1_1_6_0_or_Control000dKeyword_1_1_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	     ' | 
	     '
	 '
	 )?
	 */
	protected void emit_SingleLineAnnotation___Control000aKeyword_1_2_6_0_or_Control000dKeyword_1_2_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )*
	 */
	protected void emit_SingleLineAnnotation___Control000aKeyword_1_3_6_0_or_Control000dKeyword_1_3_6_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     '
	 ' | 
	     '
	     '
	 )*
	 */
	protected void emit_SingleLineAnnotation___Control000aKeyword_1_4_6_0_or_Control000dKeyword_1_4_6_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID*
	 */
	protected void emit_SpaceID_IDTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID?
	 */
	protected void emit_SpecialExpression_IDTerminalRuleCall_1_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID?
	 */
	protected void emit_SpecialExpression_IDTerminalRuleCall_1_2_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT | ('**' ID?)
	 */
	protected void emit_SpecialExpression_INTTerminalRuleCall_1_3_or___AsteriskAsteriskKeyword_1_1_0_IDTerminalRuleCall_1_1_2_q__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
