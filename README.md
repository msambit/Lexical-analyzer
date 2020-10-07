# lexical-analyzer
Lexical analysis is the process of converting a sequence of characters into a sequence of tokens. Programs performing lexical analysis are called lexical analyzers or lexers. The specification of a programming language will include a set of rules, often expressed syntactically, specifying the set of possible character sequences that can form a token or lexeme. The whitespace characters are often ignored during lexical analysis.

A token is a categorized block of text. The block of text corresponding to the token is known as a lexeme. A lexical analyser processes lexemes to categorize them according to function, giving them meaning.  This assignment of meaning is known as tokenization.
A token can look like anything; it just needs to be a useful part of the structured text. Consider this expression in the C programming language:
newval:=oldval+12;

Tokens are frequently defined by regular expressions, which are understood by a lexical analyser generator such as lex. The lexical analyser (either generated automatically by a tool like lex, or hand-crafted) reads in a stream of characters, identifies the lexemes in the stream, and categorizes them into tokens. This is called "tokenizing." If the lexer finds an invalid token, it will report an error.
	
Following tokenizing is parsing. From there, the interpreted data may be loaded into data structures, for general use, interpretation, or compiling.

# Stepwise-Procedure:
Read a ’C’ file as input.
Read input files of functions, operators, keywords.
Display a token for every lex unit.
Create files for symbols and literals.

