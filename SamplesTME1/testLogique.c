#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp1; 
ilptmp1 = ILP_TRUE; 
  if ( ILP_isEquivalentToTrue(ilptmp1 ) ) {
{ 
  ILP_Object ilptmp2; 
ilptmp2 = ILP_FALSE; 
  if ( ILP_isEquivalentToTrue(ilptmp2 ) ) {
{ 
  ILP_Object ilptmp3; 
  ILP_Object ilptmp4; 
ilptmp3 = ILP_Integer2ILP(1); 
ilptmp4 = ILP_Integer2ILP(2); 
return ILP_GreaterThan(ilptmp3, ilptmp4);
} 

  } else {
{ 
  ILP_Object ilptmp5; 
  ILP_Object ilptmp6; 
ilptmp5 = ILP_Integer2ILP(2); 
ilptmp6 = ILP_Integer2ILP(1); 
return ILP_GreaterThan(ilptmp5, ilptmp6);
} 

  }
}

  } else {
return ILP_FALSE; 

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
