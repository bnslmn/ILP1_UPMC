#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;
ILP_Object delta_3d;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp1; 
ilptmp1 = ILP_Integer2ILP(1); 

  {
    ILP_Object a1 = ilptmp1;
{ 
  ILP_Object ilptmp2; 
ilptmp2 = ILP_Integer2ILP(2); 

  {
    ILP_Object b2 = ilptmp2;
{ 
  ILP_Object ilptmp3; 
ilptmp3 = ILP_Integer2ILP(1); 

  {
    ILP_Object c3 = ilptmp3;
{ 
  ILP_Object ilptmp4; 
{ 
  ILP_Object ilptmp5; 
  ILP_Object ilptmp6; 
{ 
  ILP_Object ilptmp7; 
  ILP_Object ilptmp8; 
ilptmp7 = b2; 
ilptmp8 = b2; 
ilptmp5 = ILP_Times(ilptmp7, ilptmp8);
} 
{ 
  ILP_Object ilptmp9; 
  ILP_Object ilptmp10; 
{ 
  ILP_Object ilptmp11; 
  ILP_Object ilptmp12; 
ilptmp11 = ILP_Integer2ILP(4); 
ilptmp12 = a1; 
ilptmp9 = ILP_Times(ilptmp11, ilptmp12);
} 
ilptmp10 = c3; 
ilptmp6 = ILP_Times(ilptmp9, ilptmp10);
} 
ilptmp4 = ILP_Minus(ilptmp5, ilptmp6);
} 

  {
    ILP_Object delta4 = ilptmp4;
{ 
  ILP_Object ilptmp13; 
{ 
  ILP_Object ilptmp14; 
  ILP_Object ilptmp15; 
ilptmp14 = delta4; 
ilptmp15 = ILP_Integer2ILP(0); 
ilptmp13 = ILP_LessThan(ilptmp14, ilptmp15);
} 
  if ( ILP_isEquivalentToTrue(ilptmp13 ) ) {
{ 
  ILP_Object ilptmp16; 
ilptmp16 =  ILP_String2ILP("Pas de solutions !"); 
return ILP_print(ilptmp16);
}

  } else {
{ 
  ILP_Object ilptmp17; 
{ 
  ILP_Object ilptmp18; 
  ILP_Object ilptmp19; 
ilptmp18 = delta4; 
ilptmp19 = ILP_Integer2ILP(0); 
ilptmp17 = ILP_GreaterThan(ilptmp18, ilptmp19);
} 
  if ( ILP_isEquivalentToTrue(ilptmp17 ) ) {
{ 
  ILP_Object ilptmp20; 
ilptmp20 =  ILP_String2ILP("Discriminant positif : deux solutions"); 
return ILP_print(ilptmp20);
}

  } else {
{ 
  ILP_Object ilptmp21; 
ilptmp21 = delta_3d; 
  if ( ILP_isEquivalentToTrue(ilptmp21 ) ) {
{ 
  ILP_Object ilptmp22; 
ilptmp22 =  ILP_String2ILP("Discriminant nul : une seule solution"); 
return ILP_print(ilptmp22);
}

  } else {
return ILP_FALSE; 

  }
}

  }
}

  }
}

  }
}

  }
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
