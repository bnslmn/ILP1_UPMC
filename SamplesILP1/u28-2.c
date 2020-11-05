#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp90; 
  ILP_Object ilptmp91; 
ilptmp90 = ILP_Integer2ILP(1); 
ilptmp91 = ILP_Integer2ILP(2); 

  {
    ILP_Object x1 = ilptmp90;
    ILP_Object y2 = ilptmp91;
{ 
  ILP_Object ilptmp92; 
ilptmp92 = ILP_Integer2ILP(3); 

  {
    ILP_Object y3 = ilptmp92;
{ 
  ILP_Object ilptmp93; 
  ILP_Object ilptmp94; 
ilptmp93 = x1; 
ilptmp94 = y3; 
return ILP_Plus(ilptmp93, ilptmp94);
} 

  }
}

  }
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
