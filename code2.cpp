#include<iostream>
#include<fstream>
#include<string>
using namespace std;

class Photo{
    char orientation;
    int numberoftags;
    string tagarr[1000];

    public:
    // Photo(){
    //     //Blank
    // }
    // Photo(char ori, int tags){
    //     //test constructor
    //     orientation = ori;
    //     numberoftags = tags;
        
    // }
    // Photo(char ori, int tags, string arr){
    //     orientation = ori;
    //     numberoftags = tags;
    //     tagarr[999] = arr;
    // }

    void display(){
        cout<<orientation<<numberoftags;
        for(int i=0; i<numberoftags;i++){
            cout<<tagarr[i];
        }
    }

    //Test Display overload
    void display(int i){
        cout<<orientation<<numberoftags;
    }

};

int p; //no of photos



void input(){
    bool firstline=true;

    ifstream infile;
    infile.open("a_example.txt");

    //ofstream output("output.out");
    char ori;
    int numbertags;
    string arr[1000];

    while(infile){
        if(firstline){
        infile>>p;
        firstline = false;
        }
        else{
            Photo item[p];
            for(int i=0; i<p; i++){
                infile.read((char *) & item[i], sizeof(item[i]));
            }

            // cout<<ori<<numbertags;
            //     // for(int i=0; i<numbertags; i++){
            //     //     cout<<arr[i];
            //     // }
            //     cout<<endl;    
                  
        }
    }
    
}

int main(){
    //cout<<"Hello"<<endl;
    input();
    

}