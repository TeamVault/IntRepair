package org.xtext.example.mydsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int RULE_MY_STRING=8;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=16;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_MY_BACKSLASH=11;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=14;
    public static final int RULE_STRING=9;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_CURLY_OPEN=6;
    public static final int RULE_CURLY_CLOSE=7;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_DOUBLE_SQ_STRING=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_DOUBLE_DQ_STRING=10;
    public static final int RULE_WS=15;

    // delegates
    // delegators

    public InternalMyDslLexer() {;} 
    public InternalMyDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMyDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:11:7: ( ' ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:11:9: ' '
            {
            match(' '); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:12:7: ( '\\n' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:12:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:13:7: ( '\\r' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:13:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:14:7: ( '*' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:14:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:15:7: ( '**' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:15:9: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:16:7: ( '/*@ ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:16:9: '/*@ '
            {
            match("/*@ "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:17:7: ( '* ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:17:9: '* '
            {
            match("* "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:18:7: ( ' @*/' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:18:9: ' @*/'
            {
            match(" @*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:19:7: ( '@*/' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:19:9: '@*/'
            {
            match("@*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:20:7: ( '@function ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:20:9: '@function '
            {
            match("@function "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:21:7: ( 'H' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:21:9: 'H'
            {
            match('H'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:22:7: ( 'L' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:22:9: 'L'
            {
            match('L'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:23:7: ( '@parameter ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:23:9: '@parameter '
            {
            match("@parameter "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:24:7: ( '@preStep ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:24:9: '@preStep '
            {
            match("@preStep "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:25:7: ( '@postStep ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:25:9: '@postStep '
            {
            match("@postStep "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:26:7: ( '//@ @function ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:26:9: '//@ @function '
            {
            match("//@ @function "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:27:7: ( '//@ @parameter ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:27:9: '//@ @parameter '
            {
            match("//@ @parameter "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:28:7: ( '//@ @variable ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:28:9: '//@ @variable '
            {
            match("//@ @variable "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:29:7: ( '//@ @preStep ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:29:9: '//@ @preStep '
            {
            match("//@ @preStep "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:30:7: ( '//@ @postStep ' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:30:9: '//@ @postStep '
            {
            match("//@ @postStep "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:31:7: ( '__BEGIN_DECLS' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:31:9: '__BEGIN_DECLS'
            {
            match("__BEGIN_DECLS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:32:7: ( '__BEGIN_NAMESPACE_STD' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:32:9: '__BEGIN_NAMESPACE_STD'
            {
            match("__BEGIN_NAMESPACE_STD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:33:7: ( '__BEGIN_NAMESPACE_C99' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:33:9: '__BEGIN_NAMESPACE_C99'
            {
            match("__BEGIN_NAMESPACE_C99"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:34:7: ( '__END_DECLS' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:34:9: '__END_DECLS'
            {
            match("__END_DECLS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:35:7: ( '__END_NAMESPACE_STD' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:35:9: '__END_NAMESPACE_STD'
            {
            match("__END_NAMESPACE_STD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:36:7: ( '__END_NAMESPACE_C99' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:36:9: '__END_NAMESPACE_C99'
            {
            match("__END_NAMESPACE_C99"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:37:7: ( '__USING_NAMESPACE_STD' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:37:9: '__USING_NAMESPACE_STD'
            {
            match("__USING_NAMESPACE_STD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:38:7: ( 'define' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:38:9: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:39:7: ( 'ifndef' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:39:9: 'ifndef'
            {
            match("ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:40:7: ( 'undef' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:40:9: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:41:7: ( 'ifdef' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:41:9: 'ifdef'
            {
            match("ifdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:42:7: ( 'if' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:42:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:43:7: ( 'include' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:43:9: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:44:7: ( 'include_next' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:44:9: 'include_next'
            {
            match("include_next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:45:7: ( 'pragma' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:45:9: 'pragma'
            {
            match("pragma"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:46:7: ( 'else' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:46:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:47:7: ( 'elif' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:47:9: 'elif'
            {
            match("elif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:48:7: ( 'error' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:48:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:49:7: ( 'typedef' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:49:9: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:50:7: ( 'class' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:50:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:51:7: ( 'endif' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:51:9: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:52:7: ( 'source' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:52:9: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:53:7: ( ',' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:53:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:54:7: ( '.' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:54:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:55:7: ( '..' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:55:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:56:7: ( '...' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:56:9: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:57:7: ( '\\f' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:57:9: '\\f'
            {
            match('\f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:58:7: ( ';' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:58:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:59:7: ( '[' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:59:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:60:7: ( ']' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:60:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:61:7: ( '(' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:61:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:62:7: ( ')' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:62:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:63:7: ( '>>' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:63:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:64:7: ( '<<' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:64:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:65:7: ( '>' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:65:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:66:7: ( '<' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:66:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:67:7: ( '^' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:67:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:68:7: ( '+' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:68:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:69:7: ( '-' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:69:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:70:7: ( '/' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:70:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:71:7: ( '%' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:71:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:72:7: ( '|' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:72:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:73:7: ( '->' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:73:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:74:7: ( '<-' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:74:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:75:7: ( '=' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:75:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:76:7: ( '?' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:76:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:77:7: ( '!' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:77:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:78:7: ( ':' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:78:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:79:7: ( '&' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:79:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:7: ( '~' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:7: ( '#' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:7: ( 'declassification' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:9: 'declassification'
            {
            match("declassification"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:83:7: ( 'sanitization' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:83:9: 'sanitization'
            {
            match("sanitization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:84:7: ( 'sink' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:84:9: 'sink'
            {
            match("sink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:85:7: ( 'trust_boundary' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:85:9: 'trust_boundary'
            {
            match("trust_boundary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:86:7: ( 'confidential' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:86:9: 'confidential'
            {
            match("confidential"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:87:7: ( 'sensitive' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:87:9: 'sensitive'
            {
            match("sensitive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "RULE_MY_BACKSLASH"
    public final void mRULE_MY_BACKSLASH() throws RecognitionException {
        try {
            int _type = RULE_MY_BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2659:19: ( '\\\\' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2659:21: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MY_BACKSLASH"

    // $ANTLR start "RULE_DOUBLE_DQ_STRING"
    public final void mRULE_DOUBLE_DQ_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_DQ_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2661:23: ( '\\'\"\\' ~(\\'\"\\')* \\'\"\\'' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2661:25: '\\'\"\\' ~(\\'\"\\')* \\'\"\\''
            {
            match("'\"' ~('\"')* '\"'"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_DQ_STRING"

    // $ANTLR start "RULE_DOUBLE_SQ_STRING"
    public final void mRULE_DOUBLE_SQ_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_SQ_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2663:23: ( '\\'\\'\\' ~(\\'\\'\\')* \\'\\'\\'' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2663:25: '\\'\\'\\' ~(\\'\\'\\')* \\'\\'\\''
            {
            match("''' ~(''')* '''"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_SQ_STRING"

    // $ANTLR start "RULE_CURLY_OPEN"
    public final void mRULE_CURLY_OPEN() throws RecognitionException {
        try {
            int _type = RULE_CURLY_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2665:17: ( '{' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2665:19: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CURLY_OPEN"

    // $ANTLR start "RULE_CURLY_CLOSE"
    public final void mRULE_CURLY_CLOSE() throws RecognitionException {
        try {
            int _type = RULE_CURLY_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2667:18: ( '}' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2667:20: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CURLY_CLOSE"

    // $ANTLR start "RULE_MY_STRING"
    public final void mRULE_MY_STRING() throws RecognitionException {
        try {
            int _type = RULE_MY_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:16: ( ( '\"' ( '\\\\' | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:18: ( '\"' ( '\\\\' | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:18: ( '\"' ( '\\\\' | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\"') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\'') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:19: '\"' ( '\\\\' | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:23: ( '\\\\' | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop1:
                    do {
                        int alt1=3;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='\\') ) {
                            alt1=1;
                        }
                        else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                            alt1=2;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:24: '\\\\'
                    	    {
                    	    match('\\'); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:29: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:49: '\\'' ( '\\\\' | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:54: ( '\\\\' | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:55: '\\\\'
                    	    {
                    	    match('\\'); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2669:60: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MY_STRING"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2671:17: ( '//' ~ ( '@' ) (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2671:19: '//' ~ ( '@' ) (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' )*
            {
            match("//"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2671:31: (~ ( ( '\\n' | '\\r' ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2671:31: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2671:47: ( '\\n' | '\\r' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* ~ ( '@' ) '*/' (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* ~ ( '@' ) '*/' (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' )*
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:31: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='?')||(LA6_0>='A' && LA6_0<='\uFFFF')) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='*') ) {
                        int LA6_3 = input.LA(3);

                        if ( (LA6_3=='/') ) {
                            alt6=2;
                        }
                        else if ( ((LA6_3>='\u0000' && LA6_3<='.')||(LA6_3>='0' && LA6_3<='\uFFFF')) ) {
                            alt6=1;
                        }


                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<=')')||(LA6_1>='+' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( (LA6_0=='@') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match("*/"); 

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:75: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:75: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2673:91: ( '\\n' | '\\r' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2675:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2675:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2675:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2675:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2675:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2677:10: ( ( '0' .. '9' )+ )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2677:12: ( '0' .. '9' )+
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2677:12: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2677:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2679:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2681:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2681:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2681:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2683:16: ( . )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:2683:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | RULE_MY_BACKSLASH | RULE_DOUBLE_DQ_STRING | RULE_DOUBLE_SQ_STRING | RULE_CURLY_OPEN | RULE_CURLY_CLOSE | RULE_MY_STRING | RULE_SL_COMMENT | RULE_ML_COMMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt16=90;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:160: T__42
                {
                mT__42(); 

                }
                break;
            case 27 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:166: T__43
                {
                mT__43(); 

                }
                break;
            case 28 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:172: T__44
                {
                mT__44(); 

                }
                break;
            case 29 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:178: T__45
                {
                mT__45(); 

                }
                break;
            case 30 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:184: T__46
                {
                mT__46(); 

                }
                break;
            case 31 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:190: T__47
                {
                mT__47(); 

                }
                break;
            case 32 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:196: T__48
                {
                mT__48(); 

                }
                break;
            case 33 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:202: T__49
                {
                mT__49(); 

                }
                break;
            case 34 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:208: T__50
                {
                mT__50(); 

                }
                break;
            case 35 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:214: T__51
                {
                mT__51(); 

                }
                break;
            case 36 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:220: T__52
                {
                mT__52(); 

                }
                break;
            case 37 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:226: T__53
                {
                mT__53(); 

                }
                break;
            case 38 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:232: T__54
                {
                mT__54(); 

                }
                break;
            case 39 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:238: T__55
                {
                mT__55(); 

                }
                break;
            case 40 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:244: T__56
                {
                mT__56(); 

                }
                break;
            case 41 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:250: T__57
                {
                mT__57(); 

                }
                break;
            case 42 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:256: T__58
                {
                mT__58(); 

                }
                break;
            case 43 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:262: T__59
                {
                mT__59(); 

                }
                break;
            case 44 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:268: T__60
                {
                mT__60(); 

                }
                break;
            case 45 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:274: T__61
                {
                mT__61(); 

                }
                break;
            case 46 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:280: T__62
                {
                mT__62(); 

                }
                break;
            case 47 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:286: T__63
                {
                mT__63(); 

                }
                break;
            case 48 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:292: T__64
                {
                mT__64(); 

                }
                break;
            case 49 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:298: T__65
                {
                mT__65(); 

                }
                break;
            case 50 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:304: T__66
                {
                mT__66(); 

                }
                break;
            case 51 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:310: T__67
                {
                mT__67(); 

                }
                break;
            case 52 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:316: T__68
                {
                mT__68(); 

                }
                break;
            case 53 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:322: T__69
                {
                mT__69(); 

                }
                break;
            case 54 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:328: T__70
                {
                mT__70(); 

                }
                break;
            case 55 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:334: T__71
                {
                mT__71(); 

                }
                break;
            case 56 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:340: T__72
                {
                mT__72(); 

                }
                break;
            case 57 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:346: T__73
                {
                mT__73(); 

                }
                break;
            case 58 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:352: T__74
                {
                mT__74(); 

                }
                break;
            case 59 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:358: T__75
                {
                mT__75(); 

                }
                break;
            case 60 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:364: T__76
                {
                mT__76(); 

                }
                break;
            case 61 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:370: T__77
                {
                mT__77(); 

                }
                break;
            case 62 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:376: T__78
                {
                mT__78(); 

                }
                break;
            case 63 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:382: T__79
                {
                mT__79(); 

                }
                break;
            case 64 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:388: T__80
                {
                mT__80(); 

                }
                break;
            case 65 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:394: T__81
                {
                mT__81(); 

                }
                break;
            case 66 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:400: T__82
                {
                mT__82(); 

                }
                break;
            case 67 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:406: T__83
                {
                mT__83(); 

                }
                break;
            case 68 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:412: T__84
                {
                mT__84(); 

                }
                break;
            case 69 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:418: T__85
                {
                mT__85(); 

                }
                break;
            case 70 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:424: T__86
                {
                mT__86(); 

                }
                break;
            case 71 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:430: T__87
                {
                mT__87(); 

                }
                break;
            case 72 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:436: T__88
                {
                mT__88(); 

                }
                break;
            case 73 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:442: T__89
                {
                mT__89(); 

                }
                break;
            case 74 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:448: T__90
                {
                mT__90(); 

                }
                break;
            case 75 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:454: T__91
                {
                mT__91(); 

                }
                break;
            case 76 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:460: T__92
                {
                mT__92(); 

                }
                break;
            case 77 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:466: T__93
                {
                mT__93(); 

                }
                break;
            case 78 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:472: RULE_MY_BACKSLASH
                {
                mRULE_MY_BACKSLASH(); 

                }
                break;
            case 79 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:490: RULE_DOUBLE_DQ_STRING
                {
                mRULE_DOUBLE_DQ_STRING(); 

                }
                break;
            case 80 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:512: RULE_DOUBLE_SQ_STRING
                {
                mRULE_DOUBLE_SQ_STRING(); 

                }
                break;
            case 81 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:534: RULE_CURLY_OPEN
                {
                mRULE_CURLY_OPEN(); 

                }
                break;
            case 82 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:550: RULE_CURLY_CLOSE
                {
                mRULE_CURLY_CLOSE(); 

                }
                break;
            case 83 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:567: RULE_MY_STRING
                {
                mRULE_MY_STRING(); 

                }
                break;
            case 84 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:582: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 85 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:598: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 86 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:614: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 87 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:622: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 88 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:631: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 89 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:643: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 90 :
                // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1:651: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\62\1\64\1\65\1\70\1\73\1\60\1\77\1\101\11\100\1\uffff"+
        "\1\125\6\uffff\1\135\1\140\1\141\1\uffff\1\144\12\uffff\1\60\2\uffff"+
        "\1\60\25\uffff\2\100\1\u0087\16\100\1\uffff\1\u0098\33\uffff\1\u009b"+
        "\17\uffff\7\100\1\uffff\17\100\2\uffff\1\u009b\2\uffff\1\u009b\3"+
        "\uffff\1\u009b\3\uffff\12\100\1\u00c7\1\u00c8\10\100\1\u00d1\1\100"+
        "\3\uffff\6\100\1\u00dc\1\100\1\u00de\1\100\2\uffff\1\u00e0\1\u00e1"+
        "\2\100\1\u00e4\3\100\1\uffff\1\100\3\uffff\3\100\1\u00f0\1\100\1"+
        "\u00f2\1\uffff\1\100\1\uffff\1\u00f4\2\uffff\2\100\1\uffff\1\100"+
        "\1\u00f8\2\100\3\uffff\4\100\1\uffff\1\100\1\uffff\1\u0101\1\uffff"+
        "\1\u0102\2\100\1\uffff\10\100\2\uffff\16\100\1\u011c\12\100\1\uffff"+
        "\2\100\1\u0129\11\100\1\uffff\3\100\1\u0136\1\100\1\u0138\1\u0139"+
        "\1\u013a\4\100\1\uffff\1\100\3\uffff\4\100\1\u0144\4\100\1\uffff"+
        "\3\100\1\u014d\4\100\1\uffff\6\100\1\u0159\1\u015a\3\100\2\uffff"+
        "\1\100\1\u015f\1\u0160\1\u0161\3\uffff";
    static final String DFA16_eofS =
        "\u0162\uffff";
    static final String DFA16_minS =
        "\1\0\3\11\1\40\2\52\2\60\1\137\1\145\1\146\1\156\1\162\1\154\1\162"+
        "\1\154\1\141\1\uffff\1\56\6\uffff\1\76\1\55\1\101\1\uffff\1\76\12"+
        "\uffff\1\0\2\uffff\1\0\14\uffff\2\0\3\uffff\1\141\3\uffff\1\102"+
        "\1\143\1\60\1\143\1\144\1\141\1\151\1\162\1\144\1\160\1\165\1\141"+
        "\1\156\1\165\3\156\1\uffff\1\56\32\uffff\1\0\1\47\2\0\2\uffff\2"+
        "\0\4\uffff\1\40\4\uffff\1\105\1\116\1\123\1\151\1\154\1\144\1\145"+
        "\1\uffff\1\154\1\145\1\147\1\145\1\146\1\157\1\151\1\145\2\163\1"+
        "\146\1\162\1\151\1\153\1\163\2\uffff\1\40\2\uffff\3\0\1\uffff\3"+
        "\0\1\100\1\107\1\104\1\111\1\156\1\141\1\145\1\146\1\165\1\146\1"+
        "\155\2\60\1\162\1\146\1\144\1\164\1\163\1\151\1\143\1\164\1\60\1"+
        "\151\2\uffff\1\146\1\111\1\137\1\116\1\145\1\163\1\146\1\60\1\144"+
        "\1\60\1\141\2\uffff\2\60\1\145\1\137\1\60\1\144\1\145\1\151\1\uffff"+
        "\1\164\1\uffff\1\141\1\uffff\1\116\1\104\1\107\1\60\1\163\1\60\1"+
        "\uffff\1\145\1\uffff\1\60\2\uffff\1\146\1\142\1\uffff\1\145\1\60"+
        "\1\172\1\151\3\uffff\1\137\1\105\1\101\1\137\1\uffff\1\151\1\uffff"+
        "\1\60\1\uffff\1\60\1\157\1\156\1\uffff\1\141\1\166\1\104\1\103\1"+
        "\115\1\116\1\146\1\156\2\uffff\1\165\2\164\1\145\1\105\1\101\1\114"+
        "\1\105\1\101\1\151\1\145\1\156\2\151\1\60\1\103\1\115\2\123\1\115"+
        "\1\143\1\170\1\144\1\141\1\157\1\uffff\1\114\1\105\1\60\1\120\1"+
        "\105\1\141\1\164\1\141\1\154\1\156\2\123\1\uffff\1\101\1\123\1\164"+
        "\1\60\1\162\3\60\1\120\1\103\1\120\1\151\1\uffff\1\171\3\uffff\1"+
        "\101\1\105\1\101\1\157\1\60\1\103\1\137\1\103\1\156\1\uffff\1\105"+
        "\1\103\1\105\1\60\1\137\1\124\1\71\1\137\1\uffff\1\103\1\104\1\71"+
        "\1\123\1\124\1\71\2\60\1\124\1\104\1\71\2\uffff\1\104\3\60\3\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\100\2\40\1\52\1\57\1\160\2\172\1\137\1\145\2\156\2\162"+
        "\1\171\2\157\1\uffff\1\56\6\uffff\1\76\1\74\1\172\1\uffff\1\76\12"+
        "\uffff\1\uffff\2\uffff\1\uffff\14\uffff\2\uffff\3\uffff\1\162\3"+
        "\uffff\1\125\1\146\1\172\1\143\1\144\1\141\1\163\1\162\1\144\1\160"+
        "\1\165\1\141\1\156\1\165\3\156\1\uffff\1\56\32\uffff\1\uffff\1\47"+
        "\2\uffff\2\uffff\2\uffff\4\uffff\1\40\4\uffff\1\105\1\116\1\123"+
        "\1\151\1\154\1\144\1\145\1\uffff\1\154\1\145\1\147\1\145\1\146\1"+
        "\157\1\151\1\145\2\163\1\146\1\162\1\151\1\153\1\163\2\uffff\1\40"+
        "\2\uffff\3\uffff\1\uffff\3\uffff\1\100\1\107\1\104\1\111\1\156\1"+
        "\141\1\145\1\146\1\165\1\146\1\155\2\172\1\162\1\146\1\144\1\164"+
        "\1\163\1\151\1\143\1\164\1\172\1\151\2\uffff\1\166\1\111\1\137\1"+
        "\116\1\145\1\163\1\146\1\172\1\144\1\172\1\141\2\uffff\2\172\1\145"+
        "\1\137\1\172\1\144\1\145\1\151\1\uffff\1\164\1\uffff\1\162\1\uffff"+
        "\2\116\1\107\1\172\1\163\1\172\1\uffff\1\145\1\uffff\1\172\2\uffff"+
        "\1\146\1\142\1\uffff\1\145\2\172\1\151\3\uffff\1\137\1\105\1\101"+
        "\1\137\1\uffff\1\151\1\uffff\1\172\1\uffff\1\172\1\157\1\156\1\uffff"+
        "\1\141\1\166\1\116\1\103\1\115\1\116\1\146\1\156\2\uffff\1\165\2"+
        "\164\1\145\1\105\1\101\1\114\1\105\1\101\1\151\1\145\1\156\2\151"+
        "\1\172\1\103\1\115\2\123\1\115\1\143\1\170\1\144\1\141\1\157\1\uffff"+
        "\1\114\1\105\1\172\1\120\1\105\1\141\1\164\1\141\1\154\1\156\2\123"+
        "\1\uffff\1\101\1\123\1\164\1\172\1\162\3\172\1\120\1\103\1\120\1"+
        "\151\1\uffff\1\171\3\uffff\1\101\1\105\1\101\1\157\1\172\1\103\1"+
        "\137\1\103\1\156\1\uffff\1\105\1\123\1\105\1\172\1\137\1\124\1\71"+
        "\1\137\1\uffff\1\123\1\104\1\71\1\123\1\124\1\71\2\172\1\124\1\104"+
        "\1\71\2\uffff\1\104\3\172\3\uffff";
    static final String DFA16_acceptS =
        "\22\uffff\1\53\1\uffff\1\57\1\60\1\61\1\62\1\63\1\64\3\uffff\1\72"+
        "\1\uffff\1\75\1\76\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\116"+
        "\1\uffff\1\121\1\122\1\uffff\1\126\1\127\1\131\1\132\1\10\1\1\1"+
        "\131\1\2\1\3\1\5\1\7\1\4\2\uffff\1\74\1\11\1\12\1\uffff\1\13\1\126"+
        "\1\14\21\uffff\1\53\1\uffff\1\54\1\57\1\60\1\61\1\62\1\63\1\64\1"+
        "\65\1\67\1\66\1\100\1\70\1\71\1\72\1\77\1\73\1\75\1\76\1\101\1\102"+
        "\1\103\1\104\1\105\1\106\1\107\1\116\4\uffff\1\121\1\122\2\uffff"+
        "\1\123\1\127\1\6\1\125\1\uffff\1\124\1\15\1\16\1\17\7\uffff\1\40"+
        "\17\uffff\1\56\1\55\1\uffff\1\120\1\123\3\uffff\1\123\32\uffff\1"+
        "\117\1\130\13\uffff\1\44\1\45\10\uffff\1\112\1\uffff\1\20\1\uffff"+
        "\1\22\6\uffff\1\37\1\uffff\1\36\1\uffff\1\46\1\51\2\uffff\1\50\4"+
        "\uffff\1\21\1\23\1\24\4\uffff\1\34\1\uffff\1\35\1\uffff\1\43\3\uffff"+
        "\1\52\10\uffff\1\41\1\47\31\uffff\1\115\14\uffff\1\30\14\uffff\1"+
        "\42\1\uffff\1\114\1\111\1\25\11\uffff\1\113\10\uffff\1\110\13\uffff"+
        "\1\31\1\32\4\uffff\1\26\1\27\1\33";
    static final String DFA16_specialS =
        "\1\5\50\uffff\1\2\2\uffff\1\13\14\uffff\1\10\1\4\64\uffff\1\0\1"+
        "\uffff\1\1\1\17\2\uffff\1\11\1\3\45\uffff\1\14\1\15\1\16\1\uffff"+
        "\1\12\1\6\1\7\u00bf\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\60\1\57\1\2\1\60\1\24\1\3\22\60\1\1\1\43\1\54\1\47\1\60"+
            "\1\37\1\45\1\51\1\30\1\31\1\4\1\35\1\22\1\36\1\23\1\5\12\56"+
            "\1\44\1\25\1\33\1\41\1\32\1\42\1\6\7\55\1\7\3\55\1\10\16\55"+
            "\1\26\1\50\1\27\1\34\1\11\1\60\2\55\1\20\1\12\1\16\3\55\1\13"+
            "\6\55\1\15\2\55\1\21\1\17\1\14\5\55\1\52\1\40\1\53\1\46\uff81"+
            "\60",
            "\2\63\2\uffff\1\63\22\uffff\1\63\37\uffff\1\61",
            "\2\63\2\uffff\1\63\22\uffff\1\63",
            "\2\63\2\uffff\1\63\22\uffff\1\63",
            "\1\67\11\uffff\1\66",
            "\1\71\4\uffff\1\72",
            "\1\74\73\uffff\1\75\11\uffff\1\76",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\102",
            "\1\103",
            "\1\104\7\uffff\1\105",
            "\1\106",
            "\1\107",
            "\1\110\1\uffff\1\112\3\uffff\1\111",
            "\1\114\6\uffff\1\113",
            "\1\115\2\uffff\1\116",
            "\1\120\3\uffff\1\122\3\uffff\1\121\5\uffff\1\117",
            "",
            "\1\124",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134",
            "\1\137\16\uffff\1\136",
            "\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\1\143",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\42\162\1\157\4\162\1\160\64\162\1\161\uffa3\162",
            "",
            "",
            "\42\166\1\167\71\166\1\165\uffa3\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\100\172\1\171\uffbf\172",
            "\100\174\1\173\uffbf\174",
            "",
            "",
            "",
            "\1\175\15\uffff\1\177\2\uffff\1\176",
            "",
            "",
            "",
            "\1\u0080\2\uffff\1\u0081\17\uffff\1\u0082",
            "\1\u0084\2\uffff\1\u0083",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\3\100\1\u0086"+
            "\11\100\1\u0085\14\100",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008c\11\uffff\1\u008b",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\47\162\1\u0099\64\162\1\161\uffa3\162",
            "\1\u009a",
            "\42\u009b\1\u009e\4\u009b\1\u009c\64\u009b\1\u009d\5\u009b"+
            "\1\u009e\3\u009b\1\u009e\7\u009b\1\u009e\3\u009b\1\u009e\1\u009b"+
            "\2\u009e\uff8a\u009b",
            "\47\162\1\u009f\64\162\1\161\uffa3\162",
            "",
            "",
            "\42\u009b\1\u00a0\4\u009b\1\u00a2\64\u009b\1\u00a1\5\u009b"+
            "\1\u00a2\3\u009b\1\u00a2\7\u009b\1\u00a2\3\u009b\1\u00a2\1\u009b"+
            "\2\u00a2\uff8a\u009b",
            "\42\166\1\167\71\166\1\165\uffa3\166",
            "",
            "",
            "",
            "",
            "\1\u00a3",
            "",
            "",
            "",
            "",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "",
            "\1\u00ba",
            "",
            "",
            "\0\u00bb",
            "\47\162\1\u009f\64\162\1\161\uffa3\162",
            "\47\162\1\u009f\64\162\1\161\uffa3\162",
            "",
            "\0\u00bb",
            "\42\166\1\167\71\166\1\165\uffa3\166",
            "\42\166\1\167\71\166\1\165\uffa3\166",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00d2",
            "",
            "",
            "\1\u00d3\11\uffff\1\u00d4\5\uffff\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00dd",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00df",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00e2",
            "\1\u00e3",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "",
            "\1\u00e9\15\uffff\1\u00eb\2\uffff\1\u00ea",
            "",
            "\1\u00ec",
            "\1\u00ed\11\uffff\1\u00ee",
            "\1\u00ef",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00f1",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\1\u00f3",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "",
            "\1\u00f7",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00f9",
            "\1\u00fa",
            "",
            "",
            "",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "\1\u00ff",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\u0100\1\uffff\32\100",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0103",
            "\1\u0104",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107\11\uffff\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\1\u0127",
            "\1\u0128",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0137",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "",
            "\1\u013f",
            "",
            "",
            "",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "",
            "\1\u0149",
            "\1\u014b\17\uffff\1\u014a",
            "\1\u014c",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "\1\u0153\17\uffff\1\u0152",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "",
            "",
            "\1\u015e",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | RULE_MY_BACKSLASH | RULE_DOUBLE_DQ_STRING | RULE_DOUBLE_SQ_STRING | RULE_CURLY_OPEN | RULE_CURLY_CLOSE | RULE_MY_STRING | RULE_SL_COMMENT | RULE_ML_COMMENT | RULE_ID | RULE_INT | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_111 = input.LA(1);

                        s = -1;
                        if ( (LA16_111=='\'') ) {s = 153;}

                        else if ( (LA16_111=='\\') ) {s = 113;}

                        else if ( ((LA16_111>='\u0000' && LA16_111<='&')||(LA16_111>='(' && LA16_111<='[')||(LA16_111>=']' && LA16_111<='\uFFFF')) ) {s = 114;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_113 = input.LA(1);

                        s = -1;
                        if ( (LA16_113=='\'') ) {s = 156;}

                        else if ( (LA16_113=='\\') ) {s = 157;}

                        else if ( (LA16_113=='\"'||LA16_113=='b'||LA16_113=='f'||LA16_113=='n'||LA16_113=='r'||(LA16_113>='t' && LA16_113<='u')) ) {s = 158;}

                        else if ( ((LA16_113>='\u0000' && LA16_113<='!')||(LA16_113>='#' && LA16_113<='&')||(LA16_113>='(' && LA16_113<='[')||(LA16_113>=']' && LA16_113<='a')||(LA16_113>='c' && LA16_113<='e')||(LA16_113>='g' && LA16_113<='m')||(LA16_113>='o' && LA16_113<='q')||LA16_113=='s'||(LA16_113>='v' && LA16_113<='\uFFFF')) ) {s = 155;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_41 = input.LA(1);

                        s = -1;
                        if ( (LA16_41=='\"') ) {s = 111;}

                        else if ( (LA16_41=='\'') ) {s = 112;}

                        else if ( (LA16_41=='\\') ) {s = 113;}

                        else if ( ((LA16_41>='\u0000' && LA16_41<='!')||(LA16_41>='#' && LA16_41<='&')||(LA16_41>='(' && LA16_41<='[')||(LA16_41>=']' && LA16_41<='\uFFFF')) ) {s = 114;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_118 = input.LA(1);

                        s = -1;
                        if ( (LA16_118=='\"') ) {s = 119;}

                        else if ( (LA16_118=='\\') ) {s = 117;}

                        else if ( ((LA16_118>='\u0000' && LA16_118<='!')||(LA16_118>='#' && LA16_118<='[')||(LA16_118>=']' && LA16_118<='\uFFFF')) ) {s = 118;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_58 = input.LA(1);

                        s = -1;
                        if ( (LA16_58=='@') ) {s = 123;}

                        else if ( ((LA16_58>='\u0000' && LA16_58<='?')||(LA16_58>='A' && LA16_58<='\uFFFF')) ) {s = 124;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0==' ') ) {s = 1;}

                        else if ( (LA16_0=='\n') ) {s = 2;}

                        else if ( (LA16_0=='\r') ) {s = 3;}

                        else if ( (LA16_0=='*') ) {s = 4;}

                        else if ( (LA16_0=='/') ) {s = 5;}

                        else if ( (LA16_0=='@') ) {s = 6;}

                        else if ( (LA16_0=='H') ) {s = 7;}

                        else if ( (LA16_0=='L') ) {s = 8;}

                        else if ( (LA16_0=='_') ) {s = 9;}

                        else if ( (LA16_0=='d') ) {s = 10;}

                        else if ( (LA16_0=='i') ) {s = 11;}

                        else if ( (LA16_0=='u') ) {s = 12;}

                        else if ( (LA16_0=='p') ) {s = 13;}

                        else if ( (LA16_0=='e') ) {s = 14;}

                        else if ( (LA16_0=='t') ) {s = 15;}

                        else if ( (LA16_0=='c') ) {s = 16;}

                        else if ( (LA16_0=='s') ) {s = 17;}

                        else if ( (LA16_0==',') ) {s = 18;}

                        else if ( (LA16_0=='.') ) {s = 19;}

                        else if ( (LA16_0=='\f') ) {s = 20;}

                        else if ( (LA16_0==';') ) {s = 21;}

                        else if ( (LA16_0=='[') ) {s = 22;}

                        else if ( (LA16_0==']') ) {s = 23;}

                        else if ( (LA16_0=='(') ) {s = 24;}

                        else if ( (LA16_0==')') ) {s = 25;}

                        else if ( (LA16_0=='>') ) {s = 26;}

                        else if ( (LA16_0=='<') ) {s = 27;}

                        else if ( (LA16_0=='^') ) {s = 28;}

                        else if ( (LA16_0=='+') ) {s = 29;}

                        else if ( (LA16_0=='-') ) {s = 30;}

                        else if ( (LA16_0=='%') ) {s = 31;}

                        else if ( (LA16_0=='|') ) {s = 32;}

                        else if ( (LA16_0=='=') ) {s = 33;}

                        else if ( (LA16_0=='?') ) {s = 34;}

                        else if ( (LA16_0=='!') ) {s = 35;}

                        else if ( (LA16_0==':') ) {s = 36;}

                        else if ( (LA16_0=='&') ) {s = 37;}

                        else if ( (LA16_0=='~') ) {s = 38;}

                        else if ( (LA16_0=='#') ) {s = 39;}

                        else if ( (LA16_0=='\\') ) {s = 40;}

                        else if ( (LA16_0=='\'') ) {s = 41;}

                        else if ( (LA16_0=='{') ) {s = 42;}

                        else if ( (LA16_0=='}') ) {s = 43;}

                        else if ( (LA16_0=='\"') ) {s = 44;}

                        else if ( ((LA16_0>='A' && LA16_0<='G')||(LA16_0>='I' && LA16_0<='K')||(LA16_0>='M' && LA16_0<='Z')||(LA16_0>='a' && LA16_0<='b')||(LA16_0>='f' && LA16_0<='h')||(LA16_0>='j' && LA16_0<='o')||(LA16_0>='q' && LA16_0<='r')||(LA16_0>='v' && LA16_0<='z')) ) {s = 45;}

                        else if ( ((LA16_0>='0' && LA16_0<='9')) ) {s = 46;}

                        else if ( (LA16_0=='\t') ) {s = 47;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||LA16_0=='\u000B'||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='$'||LA16_0=='`'||(LA16_0>='\u007F' && LA16_0<='\uFFFF')) ) {s = 48;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_161 = input.LA(1);

                        s = -1;
                        if ( (LA16_161=='\"') ) {s = 119;}

                        else if ( (LA16_161=='\\') ) {s = 117;}

                        else if ( ((LA16_161>='\u0000' && LA16_161<='!')||(LA16_161>='#' && LA16_161<='[')||(LA16_161>=']' && LA16_161<='\uFFFF')) ) {s = 118;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA16_162 = input.LA(1);

                        s = -1;
                        if ( (LA16_162=='\"') ) {s = 119;}

                        else if ( (LA16_162=='\\') ) {s = 117;}

                        else if ( ((LA16_162>='\u0000' && LA16_162<='!')||(LA16_162>='#' && LA16_162<='[')||(LA16_162>=']' && LA16_162<='\uFFFF')) ) {s = 118;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA16_57 = input.LA(1);

                        s = -1;
                        if ( (LA16_57=='@') ) {s = 121;}

                        else if ( ((LA16_57>='\u0000' && LA16_57<='?')||(LA16_57>='A' && LA16_57<='\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA16_117 = input.LA(1);

                        s = -1;
                        if ( (LA16_117=='\"') ) {s = 160;}

                        else if ( (LA16_117=='\\') ) {s = 161;}

                        else if ( (LA16_117=='\''||LA16_117=='b'||LA16_117=='f'||LA16_117=='n'||LA16_117=='r'||(LA16_117>='t' && LA16_117<='u')) ) {s = 162;}

                        else if ( ((LA16_117>='\u0000' && LA16_117<='!')||(LA16_117>='#' && LA16_117<='&')||(LA16_117>='(' && LA16_117<='[')||(LA16_117>=']' && LA16_117<='a')||(LA16_117>='c' && LA16_117<='e')||(LA16_117>='g' && LA16_117<='m')||(LA16_117>='o' && LA16_117<='q')||LA16_117=='s'||(LA16_117>='v' && LA16_117<='\uFFFF')) ) {s = 155;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA16_160 = input.LA(1);

                        s = -1;
                        if ( ((LA16_160>='\u0000' && LA16_160<='\uFFFF')) ) {s = 187;}

                        else s = 155;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA16_44 = input.LA(1);

                        s = -1;
                        if ( (LA16_44=='\\') ) {s = 117;}

                        else if ( ((LA16_44>='\u0000' && LA16_44<='!')||(LA16_44>='#' && LA16_44<='[')||(LA16_44>=']' && LA16_44<='\uFFFF')) ) {s = 118;}

                        else if ( (LA16_44=='\"') ) {s = 119;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA16_156 = input.LA(1);

                        s = -1;
                        if ( ((LA16_156>='\u0000' && LA16_156<='\uFFFF')) ) {s = 187;}

                        else s = 155;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA16_157 = input.LA(1);

                        s = -1;
                        if ( (LA16_157=='\'') ) {s = 159;}

                        else if ( (LA16_157=='\\') ) {s = 113;}

                        else if ( ((LA16_157>='\u0000' && LA16_157<='&')||(LA16_157>='(' && LA16_157<='[')||(LA16_157>=']' && LA16_157<='\uFFFF')) ) {s = 114;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA16_158 = input.LA(1);

                        s = -1;
                        if ( (LA16_158=='\'') ) {s = 159;}

                        else if ( (LA16_158=='\\') ) {s = 113;}

                        else if ( ((LA16_158>='\u0000' && LA16_158<='&')||(LA16_158>='(' && LA16_158<='[')||(LA16_158>=']' && LA16_158<='\uFFFF')) ) {s = 114;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA16_114 = input.LA(1);

                        s = -1;
                        if ( (LA16_114=='\'') ) {s = 159;}

                        else if ( (LA16_114=='\\') ) {s = 113;}

                        else if ( ((LA16_114>='\u0000' && LA16_114<='&')||(LA16_114>='(' && LA16_114<='[')||(LA16_114>=']' && LA16_114<='\uFFFF')) ) {s = 114;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}