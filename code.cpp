#include<iostream>
#include<fstream>
#include<string>
#include<algorithm>

using namespace std;

ifstream infile;
int p; //no of photos


class Photo{
    char orientation;
    int numberoftags;
    string tagarr[1000];

    public:
    ifstream infile;
    Photo(){
        //Default
    }
    //Methods

    void readdata(char ori, int tag, string *arr);

    string* getTagarray(){
        return tagarr;
    }

    int getOrientation(){
        return orientation;
    }

    int getNumberOfTags(){
        return numberoftags;
    }

    void display(){
        cout<<orientation<<numberoftags;
        for(int i=0; i<numberoftags;i++){
            cout<<tagarr[i];
        }
    }
};


//Function of Photo class can access global variables;
    void Photo::readdata(char ori, int tag, string *arr)
{

    orientation = ori;
    numberoftags = tag;
    for(int i=0; i<numberoftags; i++){
        tagarr[i] = arr[i];
    }
}


int tagUnion( string arr1[], string arr2[], int m, int n) 
{ 
  int i = 0, j = 0; 
  while (i < m && j < n) 
  { 
    if (arr1[i] < arr2[j]) 
       cout << arr1[i++] << " "; 
      
    else if (arr2[j] < arr1[i]) 
       cout << arr2[j++] << " "; 
      
    else
    { 
       cout << arr2[j++] << " "; 
       i++; 
    } 
  } 
}


void tagDiff(string arr1[], string arr2[], int n, int m) 
{ 
    // Traverse both arrays simultaneously. 
    int i = 0, j = 0; 
    while (i < n && j < m) 
    { 
        // Print smaller element and move  
        // ahead in array with smaller element 
        if (arr1[i] < arr2[j]) 
        { 
            cout << arr1[i]<<" "; 
            i++; 
        } 
        else if (arr2[j] < arr1[i]) 
        { 
            cout << arr2[j]<<" "; 
            j++; 
        } 
  
        // If both elements same, move ahead 
        // in both arrays. 
        else
        { 
            i++; 
            j++; 
        } 
    } 


} 



int tagIntersection(string arr1[], string arr2[], int m, int n) 
{ 
  int i = 0, j = 0; 
  while (i < m && j < n) 
  { 
    if (arr1[i] < arr2[j]) 
       i++; 
    else if (arr2[j] < arr1[i]) 
       j++; 
    else 
    { 
       cout << arr2[j] << " "; 
       i++; 
       j++; 
    } 
  } 
}

void intrestfactor(){

}





Photo* input(){
    bool firstline=true;
    infile.open("a_example.txt");

    //ofstream output("output.out");
    char ori;
    int numbertags;
    string arr[1000];

    while(!infile.eof()){
        if(firstline){
        infile>>p;
        firstline = false;
        }
        else{
            Photo photos[p];
            for(int i=0; i<p; i++){
                 infile>>ori>>numbertags;
                 for(int i=0; i<numbertags; i++){
                    infile>>arr[i];
                    
                }

                photos[i].readdata(ori, numbertags, arr);
                
            }

        return photos;
                
        }
    }
    
}

int main(){
    //cout<<"Hello"<<endl;
    Photo *photos;

    photos = input();

    // for(int i=0; i<p; i++){
    //     cout<<endl;
    //     photos[i].display();
    // }

    tagUnion(photos[0].getTagarray(), photos[1].getTagarray(), photos[0].getNumberOfTags(), photos[1].getNumberOfTags());


    



return 0;
    
    

}




