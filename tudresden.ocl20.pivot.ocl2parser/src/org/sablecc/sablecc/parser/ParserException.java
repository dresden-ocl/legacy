/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.parser;

import org.sablecc.sablecc.node.*;

public class ParserException extends Exception
{
    Token token;

    public ParserException(Token token, String  message)
    {
        super(message);
        this.token = token;
    }

    public Token getToken()
    {
        return token;
    }
}
