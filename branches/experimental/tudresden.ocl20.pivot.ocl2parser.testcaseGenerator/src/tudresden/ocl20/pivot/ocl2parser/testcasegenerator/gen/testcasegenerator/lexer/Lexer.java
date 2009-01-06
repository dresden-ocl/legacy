/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.lexer;

import java.io.*;
import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node.*;

public class Lexer
{
    protected Token token;
    protected State state = State.INIT_STATE;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    protected void filter() throws LexerException, IOException
    {
    }

    public Lexer(PushbackReader in)
    {
        this.in = in;

        if(gotoTable == null)
        {
            try
            {
                DataInputStream s = new DataInputStream(
                    new BufferedInputStream(
                    Lexer.class.getResourceAsStream("lexer.dat")));

                // read gotoTable
                int length = s.readInt();
                gotoTable = new int[length][][][];
                for(int i = 0; i < gotoTable.length; i++)
                {
                    length = s.readInt();
                    gotoTable[i] = new int[length][][];
                    for(int j = 0; j < gotoTable[i].length; j++)
                    {
                        length = s.readInt();
                        gotoTable[i][j] = new int[length][3];
                        for(int k = 0; k < gotoTable[i][j].length; k++)
                        {
                            for(int l = 0; l < 3; l++)
                            {
                                gotoTable[i][j][k][l] = s.readInt();
                            }
                        }
                    }
                }

                // read accept
                length = s.readInt();
                accept = new int[length][];
                for(int i = 0; i < accept.length; i++)
                {
                    length = s.readInt();
                    accept[i] = new int[length];
                    for(int j = 0; j < accept[i].length; j++)
                    {
                        accept[i][j] = s.readInt();
                    }
                }

                s.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
            }
        }
    }

    public Token peek() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        return token;
    }

    public Token next() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        Token result = token;
        token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = pos;
        int start_line = line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        int[][][] gotoTable = this.gotoTable[state.id()];
        int[] accept = this.accept[state.id()];
        text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(cr)
                    {
                        cr = false;
                    }
                    else
                    {
                        line++;
                        pos = 0;
                    }
                    break;
                case 13:
                    line++;
                    pos = 0;
                    cr = true;
                    break;
                default:
                    pos++;
                    cr = false;
                    break;
                };

                text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        int middle = (low + high) / 2;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = text.length();
                    accept_pos = pos;
                    accept_line = line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.TICK_STATE; break;
                                case 2: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 1:
                        {
                            Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 2:
                        {
                            Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 3:
                        {
                            Token token = new3(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                                case 1: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 4:
                        {
                            Token token = new4(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                                case 1: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 5:
                        {
                            Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 6:
                        {
                            Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 7:
                        {
                            Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 8:
                        {
                            Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 9:
                        {
                            Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 10:
                        {
                            Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 11:
                        {
                            Token token = new11(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 12:
                        {
                            Token token = new12(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 13:
                        {
                            Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 14:
                        {
                            Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 15:
                        {
                            Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 16:
                        {
                            Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 17:
                        {
                            Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 18:
                        {
                            Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 19:
                        {
                            Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 20:
                        {
                            Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 21:
                        {
                            Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 22:
                        {
                            Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.OCL_STATE; break;
                            }
                            return token;
                        }
                    case 23:
                        {
                            Token token = new23(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 24:
                        {
                            Token token = new24(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 25:
                        {
                            Token token = new25(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 26:
                        {
                            Token token = new26(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 27:
                        {
                            Token token = new27(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 28:
                        {
                            Token token = new28(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 29:
                        {
                            Token token = new29(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.INIT_STATE; break;
                            }
                            return token;
                        }
                    case 30:
                        {
                            Token token = new30(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            switch(state.id())
                            {
                                case 2: state = State.TICK_STATE; break;
                            }
                            return token;
                        }
                    }
                }
                else
                {
                    if(text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + text);
                    }
                    else
                    {
                        EOF token = new EOF(
                            start_line + 1,
                            start_pos + 1);
                        return token;
                    }
                }
            }
        }
    }

    Token new0(String text, int line, int pos) { return new TTick(text, line, pos); }
    Token new1(int line, int pos) { return new TNew(line, pos); }
    Token new2(int line, int pos) { return new TNull(line, pos); }
    Token new3(String text, int line, int pos) { return new TNewLine(text, line, pos); }
    Token new4(String text, int line, int pos) { return new TBlank(text, line, pos); }
    Token new5(int line, int pos) { return new TPackage(line, pos); }
    Token new6(int line, int pos) { return new TMetamodel(line, pos); }
    Token new7(int line, int pos) { return new TModel(line, pos); }
    Token new8(int line, int pos) { return new TInclude(line, pos); }
    Token new9(int line, int pos) { return new TTestname(line, pos); }
    Token new10(int line, int pos) { return new TSuitename(line, pos); }
    Token new11(String text, int line, int pos) { return new TBraceOpen(text, line, pos); }
    Token new12(String text, int line, int pos) { return new TBraceClose(text, line, pos); }
    Token new13(int line, int pos) { return new TError(line, pos); }
    Token new14(int line, int pos) { return new TAssign(line, pos); }
    Token new15(int line, int pos) { return new TComma(line, pos); }
    Token new16(int line, int pos) { return new TFirstName(line, pos); }
    Token new17(int line, int pos) { return new TColon(line, pos); }
    Token new18(int line, int pos) { return new TOpenparen(line, pos); }
    Token new19(int line, int pos) { return new TCloseparen(line, pos); }
    Token new20(int line, int pos) { return new TTestcase(line, pos); }
    Token new21(int line, int pos) { return new TAbstractmodel(line, pos); }
    Token new22(int line, int pos) { return new TOclexpression(line, pos); }
    Token new23(String text, int line, int pos) { return new TRealValue(text, line, pos); }
    Token new24(String text, int line, int pos) { return new TIntegerValue(text, line, pos); }
    Token new25(String text, int line, int pos) { return new TIdent(text, line, pos); }
    Token new26(String text, int line, int pos) { return new TPackageName(text, line, pos); }
    Token new27(String text, int line, int pos) { return new TCommentblock(text, line, pos); }
    Token new28(String text, int line, int pos) { return new TCommentline(text, line, pos); }
    Token new29(String text, int line, int pos) { return new TOclblock(text, line, pos); }
    Token new30(String text, int line, int pos) { return new TStringLiteral(text, line, pos); }

    private int getChar() throws IOException
    {
        if(eof)
        {
            return -1;
        }

        int result = in.read();

        if(result == -1)
        {
            eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }
    }

    protected void unread(Token token) throws IOException
    {
        String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }

        pos = token.getPos() - 1;
        line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INIT_STATE
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {35, 35, 5}, {39, 39, 6}, {40, 40, 7}, {41, 41, 8}, {44, 44, 9}, {46, 46, 10}, {47, 47, 11}, {48, 48, 12}, {49, 57, 13}, {58, 58, 14}, {65, 90, 15}, {97, 108, 16}, {109, 109, 17}, {110, 110, 18}, {111, 122, 16}, {123, 123, 19}, },
            {{9, 9, 1}, {32, 32, 4}, },
            {},
            {{10, 10, 20}, },
            {{9, 32, -3}, },
            {{97, 97, 21}, {101, 101, 22}, {105, 105, 23}, {109, 109, 24}, {111, 111, 25}, {112, 112, 26}, {115, 115, 27}, {116, 116, 28}, {125, 125, 29}, },
            {},
            {},
            {},
            {},
            {{48, 57, 30}, },
            {{42, 42, 31}, {47, 47, 32}, },
            {{46, 46, 10}, },
            {{46, 46, 10}, {48, 57, 33}, },
            {{61, 61, 34}, },
            {{46, 46, 35}, {48, 57, 36}, {65, 90, 37}, {95, 95, 38}, {97, 122, 39}, },
            {{46, 122, -17}, },
            {{46, 95, -17}, {97, 110, 39}, {111, 111, 40}, {112, 122, 39}, },
            {{46, 95, -17}, {97, 100, 39}, {101, 101, 41}, {102, 116, 39}, {117, 117, 42}, {118, 122, 39}, },
            {{35, 35, 43}, },
            {},
            {{98, 98, 44}, },
            {{114, 114, 45}, },
            {{110, 110, 46}, },
            {{101, 101, 47}, {111, 111, 48}, },
            {{99, 99, 49}, },
            {{97, 97, 50}, },
            {{117, 117, 51}, },
            {{101, 101, 52}, },
            {},
            {{48, 57, 30}, {69, 69, 53}, {101, 101, 54}, },
            {{0, 41, 55}, {42, 42, 56}, {43, 65535, 55}, },
            {{0, 9, 57}, {10, 10, 58}, {11, 12, 57}, {13, 13, 59}, {14, 65535, 57}, },
            {{46, 57, -15}, },
            {},
            {{65, 90, 60}, {97, 122, 61}, },
            {{46, 122, -17}, },
            {{46, 122, -17}, },
            {{48, 57, 62}, {65, 90, 63}, {97, 122, 64}, },
            {{46, 122, -17}, },
            {{46, 95, -17}, {97, 99, 39}, {100, 100, 65}, {101, 122, 39}, },
            {{46, 95, -17}, {97, 118, 39}, {119, 119, 66}, {120, 122, 39}, },
            {{46, 95, -17}, {97, 107, 39}, {108, 108, 67}, {109, 122, 39}, },
            {},
            {{115, 115, 68}, },
            {{114, 114, 69}, },
            {{99, 99, 70}, },
            {{116, 116, 71}, },
            {{100, 100, 72}, },
            {{108, 108, 73}, },
            {{99, 99, 74}, },
            {{105, 105, 75}, },
            {{115, 115, 76}, },
            {{43, 43, 77}, {45, 45, 78}, {48, 57, 79}, },
            {{43, 57, -55}, },
            {{0, 65535, -33}, },
            {{0, 46, 80}, {47, 47, 81}, {48, 65535, 80}, },
            {{0, 65535, -34}, },
            {},
            {{10, 10, 82}, },
            {{46, 46, 35}, {48, 57, 83}, {65, 90, 84}, {95, 95, 85}, {97, 122, 86}, },
            {{46, 122, -62}, },
            {{46, 122, -17}, },
            {{46, 122, -17}, },
            {{46, 122, -17}, },
            {{46, 100, -20}, {101, 101, 87}, {102, 122, 39}, },
            {{46, 122, -17}, },
            {{46, 107, -44}, {108, 108, 88}, {109, 122, 39}, },
            {{116, 116, 89}, },
            {{111, 111, 90}, },
            {{108, 108, 91}, },
            {{97, 97, 92}, },
            {{101, 101, 93}, },
            {{101, 101, 94}, },
            {{107, 107, 95}, },
            {{116, 116, 96}, },
            {{116, 116, 97}, },
            {{48, 57, 79}, },
            {{48, 57, 79}, },
            {{48, 57, 79}, },
            {{0, 65535, -33}, },
            {},
            {},
            {{46, 122, -62}, },
            {{46, 122, -62}, },
            {{48, 57, 98}, {65, 90, 99}, {97, 122, 100}, },
            {{46, 122, -62}, },
            {{46, 107, -44}, {108, 108, 101}, {109, 122, 39}, },
            {{46, 122, -17}, },
            {{114, 114, 102}, },
            {{114, 114, 103}, },
            {{117, 117, 104}, },
            {{109, 109, 105}, },
            {{108, 108, 106}, },
            {{120, 120, 107}, },
            {{97, 97, 108}, },
            {{101, 101, 109}, },
            {{99, 99, 110}, {110, 110, 111}, },
            {{46, 122, -62}, },
            {{46, 122, -62}, },
            {{46, 122, -62}, },
            {{46, 122, -17}, },
            {{97, 97, 112}, },
            {},
            {{100, 100, 113}, },
            {{111, 111, 114}, },
            {},
            {{112, 112, 115}, },
            {{103, 103, 116}, },
            {{110, 110, 117}, },
            {{97, 97, 118}, },
            {{97, 97, 119}, },
            {{99, 99, 120}, },
            {{101, 101, 121}, },
            {{100, 100, 122}, },
            {{114, 114, 123}, },
            {{101, 101, 124}, },
            {{97, 97, 125}, },
            {{115, 115, 126}, },
            {{109, 109, 127}, },
            {{116, 116, 128}, },
            {},
            {{101, 101, 129}, },
            {{101, 101, 130}, },
            {},
            {{109, 109, 131}, },
            {{101, 101, 132}, },
            {{101, 101, 133}, },
            {{109, 109, 134}, },
            {{108, 108, 135}, },
            {{115, 115, 136}, },
            {{101, 101, 137}, },
            {},
            {},
            {{111, 111, 138}, },
            {},
            {{115, 115, 139}, },
            {},
            {{100, 100, 140}, },
            {{105, 105, 141}, },
            {{101, 101, 142}, },
            {{111, 111, 143}, },
            {{108, 108, 144}, },
            {{110, 110, 145}, },
            {},
            {},
        }
        { // OCL_STATE
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {123, 123, 5}, },
            {{9, 9, 1}, {32, 32, 4}, },
            {},
            {{10, 10, 6}, },
            {{9, 32, -3}, },
            {{35, 35, 7}, },
            {},
            {{0, 34, 8}, {35, 35, 9}, {36, 65535, 8}, },
            {{0, 65535, -9}, },
            {{0, 34, 10}, {35, 35, 9}, {36, 124, 10}, {125, 125, 11}, {126, 65535, 10}, },
            {{0, 34, 12}, {35, 35, 13}, {36, 65535, 12}, },
            {},
            {{0, 65535, -12}, },
            {{0, 34, 10}, {35, 35, 13}, {36, 65535, -11}, },
        }
        { // TICK_STATE
            {{0, 9, 1}, {11, 12, 1}, {14, 38, 1}, {39, 39, 2}, {40, 65535, 1}, },
            {{0, 38, -2}, {40, 65535, 1}, },
            {},
        }
    };*/

    private static int[][] accept;
/*  {
        // INIT_STATE
        {-1, 4, 3, 3, 4, -1, 0, 18, 19, 15, -1, -1, 24, 24, 17, 25, 25, 25, 25, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, 12, 23, -1, -1, 24, 14, -1, 25, 25, -1, 25, 25, 25, 25, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, 23, -1, -1, -1, 28, 28, 26, 26, 25, 25, 25, 25, 1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, 23, 23, -1, 27, 28, 26, 26, -1, 26, 25, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 26, 26, 16, -1, 13, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, 20, 9, -1, 6, -1, 10, -1, -1, -1, -1, -1, -1, 21, 22, },
        // OCL_STATE
        {-1, 4, 3, 3, 4, -1, 3, -1, -1, -1, -1, 29, -1, -1, },
        // TICK_STATE
        {30, 30, 0, },

    };*/

    public static class State
    {
        public final static State INIT_STATE = new State(0);
        public final static State OCL_STATE = new State(1);
        public final static State TICK_STATE = new State(2);

        private int id;

        private State(int id)
        {
            this.id = id;
        }

        public int id()
        {
            return id;
        }
    }
}
