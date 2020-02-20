
r1 = int(input("Enter no of rows of first matrix :"))
c1 = int(input("Enter no of coloumns of first matrix :"))

r2 = int(input("Enter no of rows of second matrix :"))
c2 = int(input("Enter no of coloumns of second matrix :"))

if c1!=r2:
     print("Multiplication Not possible\n")
else:

    A = []
    B = []


    print("Please enter elements of first matrix")

    for i in range(r1):         
        temp = [] 
        for j in range(c1):
             temp.append(int(input())) 
        A.append(temp)

    print("Please enter elements of second matrix")

    for i in range(r2):         
        temp = [] 
        for j in range(c2):
             temp.append(int(input())) 
        B.append(temp)


    print("First Matrix")
    for i in range(r1):         
        for j in range(c1):
             print(A[i][j],end = " ") 
        print()

    print("Second Matrix")
    for i in range(r1):         
        for j in range(c1):
             print(B[i][j],end = " ") 
        print()


    def matrix_mul(A,B,r1,c1,r2,c2):
        MAX = 100

        R = [[0 for x in range(MAX)] for y in range(MAX)]     

        for i in range(r1):
            for j in range(c2):
                for k in range(r2):
                    R[i][j] = R[i][j]+(A[i][k]*B[k][j])


        print("Resultant Matrix")
        for i in range(r1):         
            for j in range(c2):
                 print(R[i][j],end = " ") 
            print()




    matrix_mul(A,B,r1,c1,r2,c2)


        
