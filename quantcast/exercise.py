import fileinput
import sys
import string
import json
import collections


def find(input1):
    findlist=list(input1.keys())
    for key in findlist:
        res = type(input1[key])
        if (res is list):  # 如果是list类型
            tuplekey=ecoypdia["tuple"].keys()
            compare=input1[key]
            for t in tuplekey:
                t=list(t)
                flag=any([compare == t[i:i + len(compare)] for i in range(0, len(t) - len(compare) + 1)])
                if(flag):
                    result.append(ecoypdia["tuple"][tuple(t)])
            continue
        if (res is dict):
                s_All = "data"
                value = []
                value = MultpDict(input1[key], s_All, value)  # check都是dict的情况
                for v in value:
                    if (ecoypdia.__contains__(v)):
                        result.append(ecoypdia[v])
                continue
        if (res is not dict and res is not list):
            if (res is bool):
                if (input1[key] == True): value = "True"
                if (input1[key] == False): value = "False"
            else:
                if (type(input1[key]) == int):
                    value = str(input1[key])
                else:
                    value = "".join(input1[key])
            value = "data" + "_" + key + "_" + value
            if (ecoypdia.__contains__(value)):
                result.append(ecoypdia[value])


def ect(input,c):
    r=[]
    newlist = []
    for index in range(len(input)):
        newlist = newlist + input[index]
    fwith=collections.Counter(newlist)
    wordfind=list(fwith.keys())

    if (len(wordfind) == 1):
        r.append(wordfind[0])
    else:
        for word in wordfind:
            if(fwith[word]==c):
                r.append(word)
    return r

def de(input,c):
    r=[]
    fwith=collections.Counter(input)
    wordfind=list(fwith.keys())

    if (len(wordfind) == 1): r.append(wordfind[0])
    else:
        for word in wordfind:
            if(fwith[word]==c):r.append(word)

    return r


def outputall():
    k=list(DictoryBase.keys())
    for key in k:
        print(DictoryBase[key])

def MultpDict(input,s,res):

    if(type(input) != dict and type(input)!=list):
        s=s+"_"+input
        res.append(s)
        return
    if (type(input) != dict and type(input) == list):
        s = s + "_" + tuple(input)
        res.append(s)
        return
    else:
        manyk = list(input.keys())
        for subk in manyk:
            MultpDict(input[subk],s+"_"+subk,res)
    return res


def addDict(input, line):
    find = list(input.keys())
    for data in find:
        res = type(input[data])
        if (res is list):  #如果是list类型
            special = tuple(input[data])
            if (ecoypdia["tuple"].__contains__(special)):
                oldlist = ecoypdia[special]
                oldlist.append(line)
                ecoypdia[special] = oldlist
            if (ecoypdia["tuple"].__contains__(special) == False):
                li = []
                li.append(line)
                ecoypdia["tuple"][special] = li
            continue
        if (res is dict):
            s_All="data"
            value=[]
            value=MultpDict(input[data],s_All,value)  #check都是dict的情况
            for v in value:
                if (ecoypdia.__contains__(v)):
                    oldlist = ecoypdia[v]
                    oldlist.append(line)
                    ecoypdia[v] = oldlist
                if (ecoypdia.__contains__(v) == False):
                    li = []
                    li.append(line)
                    ecoypdia[v] = li
            continue
        if (res is not dict and res is not list):
            if (res is bool):
                if (input[data] == True): value = "True"
                if (input[data] == False): value = "False"
            else:
                if (type(input[data]) == int):
                    value = str (input[data])
                else:
                    value = "".join(input[data])
            value= "data" + "_" + data + "_" + value
        if (ecoypdia.__contains__(value)):
            oldlist = ecoypdia[value]
            oldlist.append(line)
            ecoypdia[value] = oldlist
        if (ecoypdia.__contains__(value) == False):
            li = []
            li.append(line)
            ecoypdia[value] = li
    return ecoypdia



if __name__ == '__main__':
   Input=[]
   DictoryBase={}

   # for line in sys.stdin:
   #     next="".join(line)
   #     next=next.replace("\n","")
   #     Input.append(next)

file_object = open("int.txt","r",encoding='utf-8')
for line in file_object:
    Input.append(line)

inputall = {}  #记录所有input的值
ecoypdia = {"tuple":{}}



blacksheet={}
i = 0
for data in Input:
   tempt = data.split(" ",1)
   if(tempt[0] == "add"):
       little=json.loads((tempt[1]))
       if(little.__contains__('id')):
           i = little["id"]
       else:
           i = i + 1
       if(blacksheet.__contains__(i)):
           blacksheet.pop(i)

       next = tempt[1].replace("\n", "")
       DictoryBase[i] = next
       addDict(little,i)
   if(tempt[0] == "get"):
       result = []
       search = json.loads("".join(tempt[1]))
       if(not search):
           outputall()
       else:
           find(search)
           result=ect(result,len(search.keys()))
           for i in result:
               if(blacksheet.__contains__(i)  == False):
                   print(DictoryBase[i])
   if (tempt[0] == "delete"):
       result = []
       deleinput = json.loads("".join(tempt[1]))
       if (not search):
           ecoypdia.clear()
           DictoryBase.clear()
       else:
           find(deleinput)
           result = ect(result, len(search.keys()))
           for i in result:
               DictoryBase.pop(i)
               blacksheet[i]="delete"




# import fileinput
# import sys
# import json
# import collections
#
#
# def addfunction(input):
#     next="".join(input)
#     little=json.loads(next)
#     flag=len(DictoryBase)
#     flag=flag+1
#     DictoryBase[flag]=little
#     return DictoryBase
#
# def outputall():
#     k=list(DictoryBase.keys())
#     for key in k:
#         print(DictoryBase[key])
# def outdelall():
#     ecoypdia.clear()
#     DictoryBase.clear()
#
# def recount(input,line,old):
#     find=list(input.keys())
#     for data in find:
#         res=type(input[data])
#         if(res is list):
#             special=tuple(input[data])
#             if(ecoypdia.__contains__(special)):
#                 oldlist=ecoypdia[special]
#                 oldlist.append(line)
#                 ecoypdia[special]=oldlist
#             if(ecoypdia.__contains__(special) == False):
#                 li=[]
#                 li.append(line)
#                 ecoypdia[special]=li
#         if(res is dict):
#             old=old+data
#             recount(input[data],line,old)
#             old=""
#         if(res is not dict and res is not list):
#             if(res is bool):
#                 if (input[data] == True): value = "True"
#                 if (input[data] == False): value = "False"
#             else:
#                  if(type(input[data]==int)):
#                      value=str(input[data])
#                  else:
#                      value="".join(input[data])
#             if(old==""):
#                 new="data"+"_"+data+"_"+value
#             if(old!=""):
#                 new="data"+"_"+old+"_"+data+"_"+value
#             if(ecoypdia.__contains__(new)):
#                 oldlist=ecoypdia[new]
#                 oldlist.append(line)
#                 ecoypdia[new]=oldlist
#             if(ecoypdia.__contains__(new)==False):
#                 li=[]
#                 li.append(line)
#                 ecoypdia[new]=li
#     return ecoypdia
#
# def ect(input,c):
#     newlist=[]
#     r=[]
#     for index in range(len(input)):
#         newlist=newlist+input[index]
#     fwith=collections.Counter(newlist)
#     wordfind=list(fwith.keys())
#
#     if (len(wordfind) == 1):
#         r.append(wordfind[0])
#         return r;
#     for word in wordfind:
#         if(fwith[word]==c):
#             r.append(word)
#     return r
#
# def unpdatfor(number):
#     workkey=list(ecoypdia.keys())
#     b=number
#     for key in workkey:
#         result=[]
#         thelist=ecoypdia[key]
#         result=[x for x in thelist if x not in b]
#         ecoypdia[key]=result
#     return ecoypdia
#
# def find(input1,sold):
#     findlist=list(input1.keys())
#     for data in findlist:
#         res=type(input1[data])
#         if(res is list):
#             monlist=list(ecoypdia.keys())
#             for key in monlist:
#                 if(type(key) == tuple):
#                     com=list(key)
#                     sample=list(input1[data])
#                     tagf=any([sample ==com[i:i+len(sample)] for i in range(0,len(com)-len(sample)+1)])
#                     if(tagf == True):resafe.append(ecoypdia[key])
#         if(res is dict):
#             sold=sold+data
#             find(input1[data],sold)
#             sold=""
#         if(res is not dict and res is not list):
#             if(type(input1[data])==bool):
#                 if(input1[data] == True):value="True"
#                 if(input1[data] == False):value="False"
#             else:
#                  if(type(input1[data]==int)):
#                      value=str(input1[data])
#                  else:
#                      value="".join(input1[data])
#             if(sold==""):
#                 new="data"+"_"+data+"_"+value
#             if(sold!=""):
#                 new="data"+"_"+sold+"_"+data+"_"+value
#             if(ecoypdia.__contains__(new)):
#                 resafe.append(ecoypdia[new])
#     return resafe
#
# if __name__ == '__main__':
#     Input=[]
#     DictoryBase={}
#     ecoypdia={}
#     inputall={}
#     i=0
#     for line in sys.stdin:
#         next="".join(line)
#         next=next.replace("\n","")
#         Input.append(next)
#     # file_object=open("int.txt","r",encoding='utf-8')
#     # for line in file_object:
#     #     Input.append(line)
#
#     for data in Input:
#         tempt=data.split(" ",1)
#         if(tempt[0] == "add"):
#             i=i+1
#             DictoryBase[i]=tempt[1]
#             nextpro="".join(tempt[1])
#             little=json.loads(nextpro)
#             ecoypdia=recount(little,i,"")
#         if(tempt[0]=="get"):
#             resafe=[]
#             next="".join(tempt[1])
#             search=json.loads(next)
#             if(not search):
#                 outputall()
#                 continue
#             res=find(search,"")
#             newresult=ect(res,len(search))
#             for i in newresult:
#                 print(DictoryBase[i])
#         if(tempt[0]=="delete"):
#             resafe=[]
#             next="".join(tempt[1])
#             search=json.loads(next)
#             if(not search):
#                 outdelall()
#                 continue
#             res=find(search,"")
#             newresult=ect(res,len(search))
#             ecoypdia=unpdatfor(newresult)
#             for i in newresult:
#                 if(DictoryBase.__contains__(i)):
#                     DictoryBase.pop(i)
#
#
#
#
#
#
#
#
#
