#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp148; 
{ 
  ILP_Object ilptmp149; 
ilptmp149 = ILP_FALSE; 
  if ( ILP_isEquivalentToTrue(ilptmp149 ) ) {
{ 
  ILP_Object ilptmp150; 
ilptmp150 =  ILP_String2ILP("invisible"); 
ilptmp148 = ILP_print(ilptmp150);
}

  } else {
ilptmp148 = ILP_FALSE; 

  }
}
ilptmp148 = ILP_Integer2ILP(47); 
return ilptmp148; 
} 

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
