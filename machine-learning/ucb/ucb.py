# -*- coding: utf-8 -*-
"""
Created on Sun Jul  1 18:39:06 2018

@author: Rahul
"""
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import math

dataset=pd.read_csv('Ads_CTR_Optimisation.csv')

N=10000
d=10

ads_selected=[]

# there is no predefined alogrithn
#this will create vector of zero with size d
numbers_of_selection=[0] * d
sums_of_rewards= [0] * d
total_reward=0
#lets create avr reward
for n in range(0,N):
    ad=0
    max_upper_bound=0
    for i in range(0,d):
        if(numbers_of_selection[i]>0):
            avg_reward=sums_of_rewards[i]/numbers_of_selection[i]
            delta_i=math.sqrt(3/2*math.log(n+1)/numbers_of_selection[i])
            #no compuet UCB
            upper_bound=avg_reward+delta_i
        else:
            upper_bound=1e400
        if(upper_bound>max_upper_bound):
            max_upper_bound=upper_bound
            ad=i
    ads_selected.append(ad)
    numbers_of_selection[ad]=numbers_of_selection[ad]+1
    reward=dataset.values[n,ad]
    sums_of_rewards[ad]=sums_of_rewards[ad]+reward
    total_reward=total_reward+reward
     
#VISUALIZE THE RESULT
    plt.hist(ads_selected)
    plt.title('Hist add Selection')
    plt.xlabel('Ads')
    plt.ylabel('Number of Time eeach ad was selected')
    plt.show()