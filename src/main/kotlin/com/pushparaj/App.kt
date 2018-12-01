package com.pushparaj

fun main(args: Array<String>){
    val list:LinkedListOfInt = LinkedListOfInt()
    for(it: Int in 1..100)
        list.add(it)
    val position:Int = readLine()!!.toInt()
    list.loopToPosition(position)
    list.display()
}
class LinkedListOfInt(){
    data class Node(var value: Int,var next: Node?)
    public var head: Node? = null
    public var last: Node? = null

    fun add(value: Int){
        val newNode: Node? = Node(value,null)
        if(head==null){
            head=newNode
            last=newNode
        }else{
            last!!.next=newNode
            last=newNode
        }
    }
    fun removeLoops(){
        var hare: Node? = head 
        var tortise: Node? = head
        var isFirstPass: Boolean = true 
        detection@ while(true){
            if(tortise!!.next!=null)
                tortise = tortise.next
            if(hare!!.next!=null)
                if(hare!!.next!!.next != null){
                    if(isFirstPass){
                        hare = hare!!.next
                        isFirstPass = false
                    }
                        
                    else
                        hare = hare!!.next!!.next
                }
                    
                else
                    break
            else
                break
            if(hare!!.next==tortise){
                tortise = head
                correction@ while(true){
                    if(hare!!.next==tortise){
                        hare!!.next=null
                        break@correction
                    }
                    tortise=tortise!!.next
                    hare=hare!!.next
                }
                break@detection
            }
        }
    }
    fun display(){
        removeLoops()
        var temp: Node? = head
        while(temp!=null){
            println(temp.value)
            temp = temp!!.next
        }
    }
    fun loopToPosition(position: Int){
        var temp: Node? = head
        for(it: Int in 2..position)
            temp = temp!!.next
        last!!.next = temp
    }
}