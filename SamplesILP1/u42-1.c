#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp134; 
{ 
  ILP_Object ilptmp135; 
  ILP_Object ilptmp136; 
ilptmp135 = ILP_Float2ILP(2.5); 
ilptmp136 = ILP_Integer2ILP(1); 
ilptmp134 = ILP_Minus(ilptmp135, ilptmp136);
} 
return ILP_print(ilptmp134);
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
