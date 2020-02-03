'''
  Uses lambda functions and OOP in Python. Simple code is better code lol
'''
class BubbleSort:
    '''
        Bubble Sort is one of the famous algorithms taught in Computer Science.
        Sadly it's a very slow one as the Big O is n^2
    '''
    bubble_sort = lambda self, dataset: self.dataset = dataset
    
        for i in range(len(self.dataset-1, 0, -1)):
            for j in range(i):
                if(self.dataset[j] > self.dataset[j+1]):
                    self.temp = self.dataset[j]
                    self.dataset[j] = self.dataset[j+1]
                    self.dataset[j+1] = temp

    def __init__(self):
        self.list = [3,6,8,4,9,7]

        bubble_sort(self.dataset)
        return self.list
